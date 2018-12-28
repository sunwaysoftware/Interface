CREATE OR REPLACE FORCE VIEW PG_VFC001 AS
SELECT "SLID"     AS F1,
       "FCZH"     AS F2,
       B.PG_NM    AS F3,
       "ZRF_ID"   AS F4,
       "ZRF_NAME" AS F5,
       C.PG_NM    AS F6,
       "CSF_ID"   AS F7,
       "CSF_NAME" AS F8,
       "CLH"      AS F9,
       D.PG_NM    AS F10,
       "LFDZ"     AS F11,
       "DYFH"     AS F12,
       "SZLC"     AS F13,
       "ZLC"      AS F14,
       E.PG_NM    AS F15,
       F.PG_NM    AS F16,
       G.PG_NM    AS F17,
       "JZMJ"     AS F18,
       "HTZJ"     AS F19,
       "JYSJ"     AS F20,
       "FZRQ"     AS F21,
       H.PG_NM    AS F23,
       I.PG_NM    AS F22,
       --j.pg_nm AS f24,
       '' AS F24,
       '' AS F25,
       '' AS F26,
       '' AS F27,
       '' AS F28,
       '' AS F29,
       "SFSYFC" AS F30,
       '' AS F31,
       "CSF_TEL",
       "ZRF_TEL",
       "JCNF",
       "UPDATETIME",
       "JG",
       "ZX",
       "SLID",
       "SSQY",
       qswsrq,
       qswsjs
  FROM FC001 A,
       CD002 B,
       CD002 C,
       CD003 D,
       CD004 E,
       CD005 F,
       CD006 G,
       CD007 H,
       CD008 I
--cd009 j
 WHERE A.ZRF_ZJLX = B.FC_ID(+)
   AND A.CSF_ZJLX = C.FC_ID(+)
   AND A.GHYT = D.FC_ID(+)
   AND A.JZJG = E.FC_ID(+)
   AND A.FWLX = F.FC_ID(+)
   AND A.JYLX = G.FC_ID(+)
   AND A.CX = H.FC_ID(+)
   AND A.DF = I.FC_ID(+);

