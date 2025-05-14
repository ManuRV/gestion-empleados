-- Script de creación de la tabla EMPLEADO

CREATE TABLE IF NOT EXISTS public.empleado
(
    id integer NOT NULL DEFAULT nextval('empleado_id_seq'::regclass),
    primer_nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    segundo_nombre character varying(50) COLLATE pg_catalog."default",
    apellido_paterno character varying(50) COLLATE pg_catalog."default" NOT NULL,
    apellido_materno character varying(50) COLLATE pg_catalog."default",
    edad integer,
    sexo character(1) COLLATE pg_catalog."default",
    fecha_nacimiento date,
    puesto character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT empleado_pkey PRIMARY KEY (id),
    CONSTRAINT empleado_edad_check CHECK (edad >= 0),
    CONSTRAINT empleado_sexo_check CHECK (sexo = ANY (ARRAY['M'::bpchar, 'F'::bpchar]))
);

ALTER TABLE IF EXISTS public.empleado
    OWNER TO postgres;
