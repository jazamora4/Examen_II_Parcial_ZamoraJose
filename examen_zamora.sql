/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     9/8/2021 19:50:32                            */
/*==============================================================*/


/*==============================================================*/
/* Table: SEG_PERFIL                                            */
/*==============================================================*/
create table SEG_PERFIL (
   COD_PERFIL           VARCHAR(8)           not null,
   NOMBRE               VARCHAR(100)         not null,
   ESTADO               VARCHAR(3)           not null
      constraint CKC_ESTADO_SEG_PERF check (ESTADO in ('INA','ACT')),
   constraint PK_SEG_PERFIL primary key (COD_PERFIL)
);

/*==============================================================*/
/* Table: SEG_USUARIO                                           */
/*==============================================================*/
create table SEG_USUARIO (
   COD_USUARIO          VARCHAR(30)          not null,
   NOMBRE               VARCHAR(150)         not null,
   IDENTIFICACION       VARCHAR(30)          not null,
   EMAIL                VARCHAR(250)         not null,
   ESTADO               VARCHAR(3)           not null
      constraint CKC_ESTADO_SEG_USUA check (ESTADO in ('ACT','INA')),
   NRO_INTENTOS_FALLIDOS NUMERIC(5)           not null,
   FECHA_ULTIMA_SESION  DATE                 not null,
   constraint PK_SEG_USUARIO primary key (COD_USUARIO)
);

/*==============================================================*/
/* Index: IDX_IDENTIFICACION                                    */
/*==============================================================*/
create unique index IDX_IDENTIFICACION on SEG_USUARIO (
IDENTIFICACION
);

/*==============================================================*/
/* Table: SEG_USUARIO_PERFIL                                    */
/*==============================================================*/
create table SEG_USUARIO_PERFIL (
   COD_USUARIO          VARCHAR(30)          not null,
   COD_PERFIL           VARCHAR(8)           not null,
   ESTADO               VARCHAR(3)           not null,
   POR_OMISION          VARCHAR(1)           not null
      constraint CKC_POR_OMISION_SEG_USUA check (POR_OMISION in ('S','N')),
   constraint PK_SEG_USUARIO_PERFIL primary key (COD_PERFIL, COD_USUARIO)
);

alter table SEG_USUARIO_PERFIL
   add constraint FK_SEG_USUA_REFERENCE_SEG_PERF foreign key (COD_PERFIL)
      references SEG_PERFIL (COD_PERFIL)
      on delete restrict on update restrict;

alter table SEG_USUARIO_PERFIL
   add constraint FK_SEG_USUA_REFERENCE_SEG_USUA foreign key (COD_USUARIO)
      references SEG_USUARIO (COD_USUARIO)
      on delete restrict on update restrict;

INSERT INTO public.seg_usuario (cod_usuario, nombre, identificacion, email, estado, nro_intentos_fallidos, fecha_ultima_sesion) VALUES ('U001', 'Jose Zamora', '1805129630', 'jazamora4@espe.edu.ec', 'ACT', 1, '2021-08-08');
INSERT INTO public.seg_usuario (cod_usuario, nombre, identificacion, email, estado, nro_intentos_fallidos, fecha_ultima_sesion) VALUES ('U002', 'Jessica Zamora', '1805129648', 'jessica2000@gmail.com', 'ACT', 1, '2021-08-08');
INSERT INTO public.seg_usuario (cod_usuario, nombre, identificacion, email, estado, nro_intentos_fallidos, fecha_ultima_sesion) VALUES ('U003', 'Fabian Zamora', '1802585719', 'jessica2000@gmail.com', 'ACT', 1, '2021-08-08');
INSERT INTO public.seg_usuario (cod_usuario, nombre, identificacion, email, estado, nro_intentos_fallidos, fecha_ultima_sesion) VALUES ('U004', 'Paul Miranda', '1802801288', 'jessica2000@gmail.com', 'ACT', 1, '2021-08-08');
INSERT INTO public.seg_perfil (cod_perfil, nombre, estado) VALUES ('CP1', 'ADMIN', 'ACT');
INSERT INTO public.seg_perfil (cod_perfil, nombre, estado) VALUES ('CP2', 'DBA', 'ACT');
INSERT INTO public.seg_perfil (cod_perfil, nombre, estado) VALUES ('CP3', 'PROGRAMADOR', 'INA');
INSERT INTO public.seg_usuario_perfil (cod_usuario, cod_perfil, estado, por_omision) VALUES ('U001', 'CP1', 'ACT', 'S');
INSERT INTO public.seg_usuario_perfil (cod_usuario, cod_perfil, estado, por_omision) VALUES ('U002', 'CP3', 'INA', 'S');