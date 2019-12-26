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
                                         I_PGJG      IN FC002.PGJG%TYPE,
                                         I_NOTE      IN FC002.NOTE%TYPE) IS

  l_xzqh fc002.xzqh%type;
BEGIN
  --判断是否存在
  BEGIN
    select xzqh
      into l_xzqh
      from fc001 t
     WHERE T.SLID = I_SLID
       and t.ssqy = i_ssqy;
  
    delete FROM bdc_wbjh.TAX_BDC@BDC T
     WHERE T.SLID = I_SLID
       and t.ssqy = i_ssqy;
    --向不动产推送完税数据
    INSERT INTO bdc_wbjh.TAX_BDC@BDC
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
       PGJG,
       NOTE,
       xzqh)
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
       I_PGJG,
       I_NOTE,
       L_xzqh);
  
    --向本地表保存数据
    delete FROM FC002 T
     WHERE T.SLID = I_SLID
       and t.ssqy = i_ssqy;
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
       PGJG,
       NOTE,
       xzqh)
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
       I_PGJG,
       I_NOTE,
       L_xzqh);
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(SQLCODE, SQLERRM);
      --RAISE_APPLICATION_ERROR(-20001, SQLERRM);
  END;

END PG_INS_FC002;
/
