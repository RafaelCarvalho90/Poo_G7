--
-- PostgreSQL database cluster dump
--

-- Started on 2023-04-13 16:43:06

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-13 16:43:07

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2023-04-13 16:43:07

--
-- PostgreSQL database dump complete
--

--
-- Database "projetoj" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-13 16:43:07

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3331 (class 1262 OID 20571)
-- Name: projetoj; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE projetoj WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE projetoj OWNER TO postgres;

\connect projetoj

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 20810)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    id integer NOT NULL,
    nome character varying(50),
    sobrenome character varying(50),
    cpf character varying(14),
    email character varying(80),
    contato character varying(30)
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 20809)
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_seq OWNER TO postgres;

--
-- TOC entry 3332 (class 0 OID 0)
-- Dependencies: 216
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.funcionario.id;


--
-- TOC entry 215 (class 1259 OID 20797)
-- Name: saldo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.saldo (
    id integer NOT NULL,
    saldo numeric
);


ALTER TABLE public.saldo OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 20796)
-- Name: saldo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.saldo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.saldo_id_seq OWNER TO postgres;

--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 214
-- Name: saldo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.saldo_id_seq OWNED BY public.saldo.id;


--
-- TOC entry 3179 (class 2604 OID 20813)
-- Name: funcionario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- TOC entry 3178 (class 2604 OID 20800)
-- Name: saldo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.saldo ALTER COLUMN id SET DEFAULT nextval('public.saldo_id_seq'::regclass);


--
-- TOC entry 3325 (class 0 OID 20810)
-- Dependencies: 217
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.funcionario (id, nome, sobrenome, cpf, email, contato) FROM stdin;
2	Gabriel	Nunes	147899474	gabriel@hotmail.com	47789741224
3	Joao	Carvalho	123554565	rafa@ggg	384440943
4	Rafael	Vieira	1447854741	rafa@vieira.com	988747777
5	Fael	Carvalho	14154784	rafa@carva	47895471
6	Jucelina	Kubisheka	4567894561	ju@sheka	696969
\.


--
-- TOC entry 3323 (class 0 OID 20797)
-- Dependencies: 215
-- Data for Name: saldo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.saldo (id, saldo) FROM stdin;
\.


--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 216
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_seq', 6, true);


--
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 214
-- Name: saldo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.saldo_id_seq', 1, false);


-- Completed on 2023-04-13 16:43:07

--
-- PostgreSQL database dump complete
--

-- Completed on 2023-04-13 16:43:07

--
-- PostgreSQL database cluster dump complete
--

