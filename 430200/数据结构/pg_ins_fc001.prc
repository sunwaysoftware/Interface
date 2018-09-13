CREATE OR REPLACE PROCEDURE PG_INS_FC001(I_SLID     IN FC001.SLID%TYPE,
                                         I_SSQY     IN FC001.SSQY%TYPE,
                                         I_FCZH     IN FC001.FCZH%TYPE,
                                         I_ZRF_NAME IN FC001.ZRF_NAME%TYPE,
                                         I_ZRF_ID   IN FC001.ZRF_ID%TYPE,
                                         I_ZRF_ZJLX IN FC001.ZRF_ZJLX%TYPE,
                                         I_ZRF_TEL  IN FC001.ZRF_TEL%TYPE,
                                         I_CSF_NAME IN FC001.CSF_NAME%TYPE,
                                         I_CSF_ID   IN FC001.CSF_ID%TYPE,
                                         I_CSF_ZJLX IN FC001.CSF_ZJLX%TYPE,
                                         I_CSF_TEL  IN FC001.CSF_TEL%TYPE,
                                         I_CLH      IN FC001.CLH%TYPE,
                                         I_GHYT     IN FC001.GHYT%TYPE,
                                         I_LFDZ     IN FC001.LFDZ%TYPE,
                                         I_DYFH     IN FC001.DYFH%TYPE,
                                         I_ZLC      IN FC001.ZLC%TYPE,
                                         I_SZLC     IN FC001.SZLC%TYPE,
                                         I_JZJG     IN FC001.JZJG%TYPE,
                                         I_FWLX     IN FC001.FWLX%TYPE,
                                         I_JYLX     IN FC001.JYLX%TYPE,
                                         I_JZMJ     IN FC001.JZMJ%TYPE,
                                         I_HTZJ     IN FC001.HTZJ%TYPE,
                                         I_FZRQ     IN FC001.SLID%TYPE,
                                         I_JCNF     IN FC001.JCNF%TYPE,
                                         I_JYSJ     IN FC001.SLID%TYPE,
                                         I_SFSYFC   IN FC001.SFSYFC%TYPE,
                                         I_CX       IN FC001.CX%TYPE,
                                         I_DF       IN FC001.DF%TYPE,
                                         I_JG       IN FC001.JG%TYPE,
                                         I_ZX       IN FC001.ZX%TYPE,
                                         I_CG       IN FC001.CG%TYPE,
                                         I_XQDM     IN FC001.XQDM%TYPE,
                                         i_wsrq     in fc001.SLID%type,
                                         i_wsjs     in fc001.qswsjs%type) IS

  L_FZRQ FC001.FZRQ%TYPE;
  L_JYSJ FC001.JYSJ%TYPE;
  l_wsrq fc001.qswsrq%type;
BEGIN

  /*  BEGIN*/
  --1、删除原数据后
  DELETE FC001 T
   WHERE T.SLID = I_SLID
     AND T.SSQY = I_SSQY;

  if null <> i_fzrq or 'null' <> i_fzrq then
    L_FZRQ := TO_DATE(I_FZRQ, 'yyyy-mm-dd');
  end if;
  if null <> I_JYSJ or 'null' <> I_JYSJ then
    L_JYSJ := TO_DATE(I_JYSJ, 'yyyy-mm-dd');
  end if;
  if null <> i_wsrq or 'null' <> i_wsrq then
    l_wsrq := TO_DATE(i_wsrq, 'yyyy-mm-dd');
  end if;

  --2、再添加
  INSERT INTO FC001
    (SLID,
     SSQY,
     FCZH,
     ZRF_NAME,
     ZRF_ID,
     ZRF_ZJLX,
     ZRF_TEL,
     CSF_NAME,
     CSF_ID,
     CSF_ZJLX,
     CSF_TEL,
     CLH,
     GHYT,
     LFDZ,
     DYFH,
     ZLC,
     SZLC,
     JZJG,
     FWLX,
     JYLX,
     JZMJ,
     HTZJ,
     FZRQ,
     JCNF,
     JYSJ,
     SFSYFC,
     CX,
     DF,
     UPDATETIME,
     JG,
     ZX,
     CG,
     XQDM,
     qswsrq,
     qswsjs)
  VALUES
    (I_SLID,
     I_SSQY,
     I_FCZH,
     I_ZRF_NAME,
     I_ZRF_ID,
     I_ZRF_ZJLX,
     I_ZRF_TEL,
     I_CSF_NAME,
     I_CSF_ID,
     I_CSF_ZJLX,
     I_CSF_TEL,
     I_CLH,
     I_GHYT,
     I_LFDZ,
     I_DYFH,
     I_ZLC,
     I_SZLC,
     I_JZJG,
     I_FWLX,
     I_JYLX,
     I_JZMJ,
     I_HTZJ,
     L_FZRQ,
     I_JCNF,
     L_JYSJ,
     nvl(I_SFSYFC, '私有房产'),
     I_CX,
     I_DF,
     SYSDATE,
     I_JG,
     I_ZX,
     I_CG,
     I_XQDM,
     l_wsrq,
     i_wsjs);
  /*  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(SQLCODE, SQLERRM);
  END;*/

END PG_INS_FC001;
/

