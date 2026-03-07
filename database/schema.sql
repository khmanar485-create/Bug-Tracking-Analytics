CREATE TABLE IF NOT EXISTS public.bugs
(
    bug_id integer NOT NULL DEFAULT nextval('bugs_bug_id_seq'::regclass),
    title character varying(100) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    status character varying(20) COLLATE pg_catalog."default" NOT NULL,
    priority character varying(20) COLLATE pg_catalog."default" NOT NULL,
    assigned_to integer,
    created_at timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT bugs_pkey PRIMARY KEY (bug_id),
    CONSTRAINT assigned_to FOREIGN KEY (assigned_to)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE IF NOT EXISTS public.users
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
)

