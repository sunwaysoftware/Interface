$(document).ready(function() {
	uploadSetting();

	$("#btnReload").click(function() {
		$('#test').datagrid('reload');
	});

});

/**
 * upload setting.
 */
function uploadSetting() {
	new SWFUpload(
			{
				// Backend Settings
				upload_url : "ADDT00352F.action",
				post_params : {
					txtXQDM : $("#txtXQDM").val(),
					txtXQDMHM : $("#txtXQDMHM").val()
				},
				// File Upload Settings
				file_size_limit : "500", // 100 kb
				file_types : "*.jpg", // *.gif; *.png",
				file_types_description : "JPG Image Files",
				file_upload_limit : "20",// 实例允许上传的最多文件数量,0表示允许上传的数量无限制
				file_queue_limit : "10",// 设置文件上传队列中等待文件的最大数量限制
				// Event Handler Settings (all my handlers are in the Handler.js
				// file)
				swfupload_preload_handler : preLoad,
				swfupload_load_failed_handler : loadFailed,
				// 此事件在selectFile或者selectFiles调用后，文件选择对话框显示之前触发。只能同时存在一个文件对话框。
				file_dialog_start_handler : fileDialogStart,
				// 当文件选择对话框关闭消失时，如果选择的文件成功加入上传队列，那么针对每个成功加入的文件都会触发一次该事件（N个文件成功加入队列，就触发N次此事件）。
				file_queued_handler : fileQueued,
				// 如果选择的文件加入到上传队列中失败，那么针对每个出错的文件都会触发一次该事件
				file_queue_error_handler : fileQueueError,
				// 当选择文件对话框关闭，并且所有选择文件已经处理完成（加入上传队列成功或者失败）时，此事件被触发
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,
				// Button Settings
				button_image_url : "../scripts/swfupload/images/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder",
				button_width : 61,
				button_height : 22,
				// Flash Settings
				flash_url : "../scripts/swfupload/swfupload.swf",
				flash9_url : "../scripts/swfupload/swfupload_fp9.swf",
				swfupload_element_id : "flashUI2", // Setting
				degraded_element_id : "degradedUI2", // Setting
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				// Debug Settings
				debug : false
			});
};

function searchDate() {
	$('#test').datagrid('options').pageIndex = 1;
	var p = $('#test').datagrid('getPager');
	if (p) {
		$(p).pagination({
			pageIndex : 1
		});
	}

	$('#test').datagrid('options').queryParams = {
		txtXQDM : $("#txtXQDM").val(),
		txtXQDMHM : $("#txtXQDMHM").val()
	};
	$('#test').datagrid('reload');
};

function MyTip(obj, tips) {
	Tip(obj, '图片', tips, 100);
	return true;
};

/**
 * 彈出窗口
 */
function showWin(zpid) {
	Show("../sjcj/DETAILT00352F.action?txtXQDM=" + $("#txtXQDM").val()
			+ "&txtZPID=" + zpid, 400, 800, zpid);
};

function delPhoto(Act, cd00352xqdm, zpid) {

	$("#loading").show();
	if (window.confirm('是否确定删除该图片？')) {
		// $("#delSimplePhotoForm").attr("action",
		// "EDITT00352F.action?txtXQDMHM="+$('#txtXQDMHM').val()+"&ACT="+ Act
		// +"&txtXQDM="+ cd00352xqdm +"&txtZPID=" + zpid + "");
		// $("#delSimplePhotoForm").submit();
		$.ajax({
			type : 'POST',
			url : 'EDITT00352F.action',
			cache : false,
			complete : function() {
				$("#loading").hide();
			},
			data : {
				txtXQDMHM : $('#txtXQDMHM').val(),
				ACT : Act,
				txtXQDM : cd00352xqdm,
				txtZPID : zpid
			},
			success : function(msg) {
				searchDate();
			},
			error : function() {

			}
		});
	} else {
		$("#loading").hide();
		return false;
	}
};
// -----------------------------------------------------------------------

/*
 * This is an example of how to cancel all the files queued up. It's made
 * somewhat generic. Just pass your SWFUpload object in to this method and it
 * loops through cancelling the uploads.
 */
function cancelQueue(instance) {
	document.getElementById(instance.customSettings.cancelButtonId).disabled = true;
	instance.stopUpload();
	var stats;

	do {
		stats = instance.getStats();
		instance.cancelUpload();
	} while (stats.files_queued !== 0);

};

/*******************************************************************************
 * Event Handlers These are my custom event handlers to make my web application
 * behave the way I went when SWFUpload completes different tasks. These aren't
 * part of the SWFUpload package. They are part of my application. Without these
 * none of the actions SWFUpload makes will show up in my application.
 ******************************************************************************/
function preLoad() {
	if (!this.support.loading) {
		alert("You need the Flash Player 9.028 or above to use SWFUpload.");
		return false;
	}
};
function loadFailed() {
	alert("Something went wrong while loading SWFUpload. If this were a real application we'd clean up and then give you an alternative");
};

function fileDialogStart() {
	/* I don't need to do anything here */
};

function fileQueued(file) {
	try {
		// You might include code here that prevents the form from being
		// submitted while the upload is in
		// progress. Then you'll want to put code in the Queue Complete handler
		// to "unblock" the form
		var progress = new FileProgress(file,
				this.customSettings.progressTarget);
		progress.setStatus("Pending...");
		progress.toggleCancel(true, this);

	} catch (ex) {
		this.debug(ex);
	}

};

function fileQueueError(file, errorCode, message) {
	try {
		if (errorCode === SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED) {
			alert("You have attempted to queue too many files.\n"
					+ (message === 0 ? "You have reached the upload limit."
							: "You may select "
									+ (message > 1 ? "up to " + message
											+ " files." : "one file.")));
			return;
		}

		var progress = new FileProgress(file,
				this.customSettings.progressTarget);
		progress.setError();
		progress.toggleCancel(false);

		switch (errorCode) {
		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
			progress.setStatus("File is too big.");
			this.debug("Error Code: File too big, File name: " + file.name
					+ ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
			progress.setStatus("Cannot upload Zero Byte files.");
			this.debug("Error Code: Zero byte file, File name: " + file.name
					+ ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
			progress.setStatus("Invalid File Type.");
			this.debug("Error Code: Invalid File Type, File name: " + file.name
					+ ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
			alert("You have selected too many files.  "
					+ (message > 1 ? "You may only add " + message
							+ " more files" : "You cannot add any more files."));
			break;
		default:
			if (file !== null) {
				progress.setStatus("Unhandled Error");
			}
			this.debug("Error Code: " + errorCode + ", File name: " + file.name
					+ ", File size: " + file.size + ", Message: " + message);
			break;
		}
	} catch (ex) {
		this.debug(ex);
	}
};

function fileDialogComplete(numFilesSelected, numFilesQueued) {
	try {
		if (this.getStats().files_queued > 0) {
			document.getElementById(this.customSettings.cancelButtonId).disabled = false;
		}

		/* I want auto start and I can do that here */
		this.startUpload();
	} catch (ex) {
		this.debug(ex);
	}
};

function uploadStart(file) {
	try {
		/*
		 * I don't want to do any file validation or anything, I'll just update
		 * the UI and return true to indicate that the upload should start
		 */
		var progress = new FileProgress(file,
				this.customSettings.progressTarget);
		progress.setStatus("Uploading...");
		progress.toggleCancel(true, this);
	} catch (ex) {
	}

	return true;
};

function uploadProgress(file, bytesLoaded, bytesTotal) {

	try {
		var percent = Math.ceil((bytesLoaded / bytesTotal) * 100);

		var progress = new FileProgress(file,
				this.customSettings.progressTarget);
		progress.setProgress(percent);
		progress.setStatus("Uploading...");
	} catch (ex) {
		this.debug(ex);
	}
};

function uploadSuccess(file, serverData) {
	try {
		var progress = new FileProgress(file,
				this.customSettings.progressTarget);
		progress.setComplete();
		progress.setStatus("Complete.");
		progress.toggleCancel(false);

	} catch (ex) {
		this.debug(ex);
	}
};

function uploadComplete(file) {
	try {
		/*
		 * I want the next upload to continue automatically so I'll call
		 * startUpload here
		 */
		if (this.getStats().files_queued === 0) {
			document.getElementById(this.customSettings.cancelButtonId).disabled = true;
		} else {
			this.startUpload();
		}
	} catch (ex) {
		this.debug(ex);
	}

};

function uploadError(file, errorCode, message) {
	try {
		var progress = new FileProgress(file,
				this.customSettings.progressTarget);
		progress.setError();
		progress.toggleCancel(false);

		switch (errorCode) {
		case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:
			progress.setStatus("Upload Error: " + message);
			this.debug("Error Code: HTTP Error, File name: " + file.name
					+ ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.MISSING_UPLOAD_URL:
			progress.setStatus("Configuration Error");
			this.debug("Error Code: No backend file, File name: " + file.name
					+ ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:
			progress.setStatus("Upload Failed.");
			this.debug("Error Code: Upload Failed, File name: " + file.name
					+ ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.IO_ERROR:
			progress.setStatus("Server (IO) Error");
			this.debug("Error Code: IO Error, File name: " + file.name
					+ ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:
			progress.setStatus("Security Error");
			this.debug("Error Code: Security Error, File name: " + file.name
					+ ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
			progress.setStatus("Upload limit exceeded.");
			this.debug("Error Code: Upload Limit Exceeded, File name: "
					+ file.name + ", File size: " + file.size + ", Message: "
					+ message);
			break;
		case SWFUpload.UPLOAD_ERROR.SPECIFIED_FILE_ID_NOT_FOUND:
			progress.setStatus("File not found.");
			this.debug("Error Code: The file was not found, File name: "
					+ file.name + ", File size: " + file.size + ", Message: "
					+ message);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED:
			progress.setStatus("Failed Validation.  Upload skipped.");
			this.debug("Error Code: File Validation Failed, File name: "
					+ file.name + ", File size: " + file.size + ", Message: "
					+ message);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
			if (this.getStats().files_queued === 0) {
				document.getElementById(this.customSettings.cancelButtonId).disabled = true;
			}
			progress.setStatus("Cancelled");
			progress.setCancelled();
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
			progress.setStatus("Stopped");
			break;
		default:
			progress.setStatus("Unhandled Error: " + error_code);
			this.debug("Error Code: " + errorCode + ", File name: " + file.name
					+ ", File size: " + file.size + ", Message: " + message);
			break;
		}
	} catch (ex) {
		this.debug(ex);
	}
};