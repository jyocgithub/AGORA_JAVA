create or replace type OB_ANIMAL as object(
    id integer,
    especie VARCHAR2(30),
              raza VARCHAR2(30),
              nombre VARCHAR2(30),
              edad integer,
              vacunas integer
              )NOT FINAL;