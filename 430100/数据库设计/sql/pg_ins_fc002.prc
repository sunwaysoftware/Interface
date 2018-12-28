CREATE OR REPLACE PROCEDURE PG_INS_FC002(I_SLID      IN FC002.SLID%TYPE,
                                         I_SSQY      IN FC002.SSQY%TYPE,
                                         I_DJZ_QS    IN FC002.DJZ_QS%TYPE,
                                         I_DJZ_YYS   IN FC002.DJZ_YYS%TYPE,
                                         I_DJZ_CJS   IN FC002.DJZ_CJS%TYPE,
                                         I_DJZ_DFJYS IN FC002.DJZ_DFJYS%TYPE,
                                         I_DJZ_GRSDS IN FC002.DJZ_GRSDS%TYPE,
                                         I_DJZ_YHS   IN FC002.DJZ_YHS%TYPE,
                                         I_DJZ_TDZZS IN FC002.DJZ_TDZZS%TYPE,
                                         I_FPHM      IN FC002.FPHM%TYPE,
                                         I_QSSPHM    IN FC002.QSSPHM%TYPE,
                                         I_DFGSSPHM  IN FC002.DFGSSPHM%TYPE,
                                         I_PGID      IN FC002.PGID%TYPE,
                                         I_PGJG      IN FC002.PGJG%TYPE) IS
  L_CNT NUMBER := 0;
BEGIN
  --读取存在个数
  SELECT COUNT(*)
    INTO L_CNT
    FROM FC002 T
   WHERE T.SLID = I_SLID
     AND T.SSQY = I_SSQY;
  --判断是否存在
  BEGIN
    IF L_CNT = 0 THEN
      --如果不存在，则添加
      INSERT INTO FC002
        (SLID,
         SSQY,
         DJZ_QS,
         DJZ_YYS,
         DJZ_CJS,
         DJZ_DFJYS,
         DJZ_GRSDS,
         DJZ_YHS,
         DJZ_TDZZS,
         FPHM,
         QSSPHM,
         DFGSSPHM,
         UPDATETIME,
         PGID,
         PGJG)
      VALUES
        (I_SLID,
         I_SSQY,
         I_DJZ_QS,
         I_DJZ_YYS,
         I_DJZ_CJS,
         I_DJZ_DFJYS,
         I_DJZ_GRSDS,
         I_DJZ_YHS,
         I_DJZ_TDZZS,
         I_FPHM,
         I_QSSPHM,
         I_DFGSSPHM,
         SYSDATE,
         I_PGID,
         I_PGJG);
    ELSE
      --如果存在，则进行更新
      UPDATE FC002
         SET DJZ_QS     = I_DJZ_QS,
             DJZ_YYS    = I_DJZ_YYS,
             DJZ_CJS    = I_DJZ_CJS,
             DJZ_DFJYS  = I_DJZ_DFJYS,
             DJZ_GRSDS  = I_DJZ_GRSDS,
             DJZ_YHS    = I_DJZ_YHS,
             DJZ_TDZZS  = I_DJZ_TDZZS,
             FPHM       = I_FPHM,
             QSSPHM     = I_QSSPHM,
             DFGSSPHM   = I_DFGSSPHM,
             UPDATETIME = SYSDATE,
             PGID       = I_PGID,
             PGJG       = I_PGJG
       WHERE SLID = I_SLID
         AND SSQY = I_SSQY;
    END IF;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(SQLCODE, SQLERRM);
  END;

END PG_INS_FC002;
/

