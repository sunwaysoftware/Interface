CREATE OR REPLACE VIEW PG_VFC001 AS
SELECT "SLID" AS f1,
       "FCZH" AS f2,
       b.pg_nm AS f3,
       "ZRF_ID" AS f4,
       "ZRF_NAME" AS f5,
       c.pg_nm AS f6,
       "CSF_ID" AS f7,
       "CSF_NAME" AS f8,
       "CLH" AS f9,
       d.pg_nm AS f10,
       "LFDZ" AS f11,
       "DYFH" AS f12,
       "SZLC" AS f13,
       "ZLC" AS f14,
       e.pg_nm AS f15,
       f.pg_nm AS f16,
       g.pg_nm AS f17,
       "JZMJ" AS f18,
       "HTZJ" AS f19,
       "JYSJ" AS f20,
       "FZRQ" AS f21,
       h.pg_nm AS f23,
       i.pg_nm AS f22,
       '' AS f24, --j.pg_nm AS f24,
       '' AS f25,
       '' AS f26,
       '' AS f27,
       a.ssqy AS f28,
       '' AS f29,
       "SFSYFC" AS f30,
       '' AS f31,
       "CSF_TEL" as CSFTEL,
       "ZRF_TEL" AS ZRFTEL,
       "JCNF",
       "QSWSRQ",
       "QSWSJS",
       "UPDATETIME",
       "JG",
       "ZX",
       "SLID",
       "SSQY",
       "XQDM" AS f0,
       xzqh
  FROM fc001 a,
       cd002 b,
       cd002 c,
       cd003 d,
       cd004 e,
       cd005 f,
       cd006 g,
       cd007 h,
       cd008 i
--cd009 j
 WHERE a.zrf_zjlx = b.fc_id(+)
   AND a.csf_zjlx = c.fc_id(+)
   AND a.ghyt = d.fc_id(+)
   AND a.jzjg = e.fc_id(+)
   AND a.fwlx = f.fc_id(+)
   AND a.jylx = g.fc_id(+)
   AND a.cx = h.fc_id(+)
   AND a.df = i.fc_id(+)
;
