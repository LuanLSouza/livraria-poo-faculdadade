PGDMP     )    +        	        |            livraria    15.4    15.4 3    1           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            2           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            3           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            4           1262    32840    livraria    DATABASE        CREATE DATABASE livraria WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE livraria;
                postgres    false            �            1259    32842    autor    TABLE     �   CREATE TABLE public.autor (
    id_autor integer NOT NULL,
    nome character varying(100),
    cpf character varying(14),
    email character varying(100)
);
    DROP TABLE public.autor;
       public         heap    postgres    false            �            1259    32841    autor_id_autor_seq    SEQUENCE     �   CREATE SEQUENCE public.autor_id_autor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.autor_id_autor_seq;
       public          postgres    false    215            5           0    0    autor_id_autor_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.autor_id_autor_seq OWNED BY public.autor.id_autor;
          public          postgres    false    214            �            1259    32872    cliente    TABLE     �   CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    nome character varying(100),
    cpf character varying(14),
    telefone character varying(20)
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    32871    cliente_id_cliente_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.cliente_id_cliente_seq;
       public          postgres    false    221            6           0    0    cliente_id_cliente_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.cliente_id_cliente_seq OWNED BY public.cliente.id_cliente;
          public          postgres    false    220            �            1259    32863    livraria    TABLE     �   CREATE TABLE public.livraria (
    id_livraria integer NOT NULL,
    nome character varying(255),
    endereco character varying(255),
    cnpj character varying(18)
);
    DROP TABLE public.livraria;
       public         heap    postgres    false            �            1259    32862    livraria_id_livraria_seq    SEQUENCE     �   CREATE SEQUENCE public.livraria_id_livraria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.livraria_id_livraria_seq;
       public          postgres    false    219            7           0    0    livraria_id_livraria_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.livraria_id_livraria_seq OWNED BY public.livraria.id_livraria;
          public          postgres    false    218            �            1259    32849    livros    TABLE     �   CREATE TABLE public.livros (
    id_livro integer NOT NULL,
    id_autor integer,
    titulo character varying(255),
    preco numeric(10,2),
    resumo text,
    faixa_etaria character(1)
);
    DROP TABLE public.livros;
       public         heap    postgres    false            �            1259    32848    livros_id_livro_seq    SEQUENCE     �   CREATE SEQUENCE public.livros_id_livro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.livros_id_livro_seq;
       public          postgres    false    217            8           0    0    livros_id_livro_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.livros_id_livro_seq OWNED BY public.livros.id_livro;
          public          postgres    false    216            �            1259    32886    venda    TABLE     �   CREATE TABLE public.venda (
    id_venda integer NOT NULL,
    id_livraria integer,
    id_livro integer,
    id_vendedor integer,
    id_cliente integer,
    quantidade integer,
    data date,
    forma_de_pagamento character(1)
);
    DROP TABLE public.venda;
       public         heap    postgres    false            �            1259    32885    venda_id_venda_seq    SEQUENCE     �   CREATE SEQUENCE public.venda_id_venda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.venda_id_venda_seq;
       public          postgres    false    225            9           0    0    venda_id_venda_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.venda_id_venda_seq OWNED BY public.venda.id_venda;
          public          postgres    false    224            �            1259    32879    vendedor    TABLE     �   CREATE TABLE public.vendedor (
    id_vendedor integer NOT NULL,
    nome character varying(100),
    cpf character varying(14),
    funcao character(1),
    admissao date
);
    DROP TABLE public.vendedor;
       public         heap    postgres    false            �            1259    32878    vendedor_id_vendedor_seq    SEQUENCE     �   CREATE SEQUENCE public.vendedor_id_vendedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.vendedor_id_vendedor_seq;
       public          postgres    false    223            :           0    0    vendedor_id_vendedor_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.vendedor_id_vendedor_seq OWNED BY public.vendedor.id_vendedor;
          public          postgres    false    222            ~           2604    32845    autor id_autor    DEFAULT     p   ALTER TABLE ONLY public.autor ALTER COLUMN id_autor SET DEFAULT nextval('public.autor_id_autor_seq'::regclass);
 =   ALTER TABLE public.autor ALTER COLUMN id_autor DROP DEFAULT;
       public          postgres    false    215    214    215            �           2604    32875    cliente id_cliente    DEFAULT     x   ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_cliente_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN id_cliente DROP DEFAULT;
       public          postgres    false    221    220    221            �           2604    32866    livraria id_livraria    DEFAULT     |   ALTER TABLE ONLY public.livraria ALTER COLUMN id_livraria SET DEFAULT nextval('public.livraria_id_livraria_seq'::regclass);
 C   ALTER TABLE public.livraria ALTER COLUMN id_livraria DROP DEFAULT;
       public          postgres    false    219    218    219                       2604    32852    livros id_livro    DEFAULT     r   ALTER TABLE ONLY public.livros ALTER COLUMN id_livro SET DEFAULT nextval('public.livros_id_livro_seq'::regclass);
 >   ALTER TABLE public.livros ALTER COLUMN id_livro DROP DEFAULT;
       public          postgres    false    217    216    217            �           2604    32889    venda id_venda    DEFAULT     p   ALTER TABLE ONLY public.venda ALTER COLUMN id_venda SET DEFAULT nextval('public.venda_id_venda_seq'::regclass);
 =   ALTER TABLE public.venda ALTER COLUMN id_venda DROP DEFAULT;
       public          postgres    false    224    225    225            �           2604    32882    vendedor id_vendedor    DEFAULT     |   ALTER TABLE ONLY public.vendedor ALTER COLUMN id_vendedor SET DEFAULT nextval('public.vendedor_id_vendedor_seq'::regclass);
 C   ALTER TABLE public.vendedor ALTER COLUMN id_vendedor DROP DEFAULT;
       public          postgres    false    223    222    223            $          0    32842    autor 
   TABLE DATA           ;   COPY public.autor (id_autor, nome, cpf, email) FROM stdin;
    public          postgres    false    215   �9       *          0    32872    cliente 
   TABLE DATA           B   COPY public.cliente (id_cliente, nome, cpf, telefone) FROM stdin;
    public          postgres    false    221   8:       (          0    32863    livraria 
   TABLE DATA           E   COPY public.livraria (id_livraria, nome, endereco, cnpj) FROM stdin;
    public          postgres    false    219   �:       &          0    32849    livros 
   TABLE DATA           Y   COPY public.livros (id_livro, id_autor, titulo, preco, resumo, faixa_etaria) FROM stdin;
    public          postgres    false    217   ;       .          0    32886    venda 
   TABLE DATA              COPY public.venda (id_venda, id_livraria, id_livro, id_vendedor, id_cliente, quantidade, data, forma_de_pagamento) FROM stdin;
    public          postgres    false    225   �;       ,          0    32879    vendedor 
   TABLE DATA           L   COPY public.vendedor (id_vendedor, nome, cpf, funcao, admissao) FROM stdin;
    public          postgres    false    223   �;       ;           0    0    autor_id_autor_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.autor_id_autor_seq', 4, true);
          public          postgres    false    214            <           0    0    cliente_id_cliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cliente_id_cliente_seq', 3, true);
          public          postgres    false    220            =           0    0    livraria_id_livraria_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.livraria_id_livraria_seq', 4, true);
          public          postgres    false    218            >           0    0    livros_id_livro_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.livros_id_livro_seq', 5, true);
          public          postgres    false    216            ?           0    0    venda_id_venda_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.venda_id_venda_seq', 2, true);
          public          postgres    false    224            @           0    0    vendedor_id_vendedor_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.vendedor_id_vendedor_seq', 4, true);
          public          postgres    false    222            �           2606    32847    autor autor_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id_autor);
 :   ALTER TABLE ONLY public.autor DROP CONSTRAINT autor_pkey;
       public            postgres    false    215            �           2606    32877    cliente cliente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    221            �           2606    32870    livraria livraria_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.livraria
    ADD CONSTRAINT livraria_pkey PRIMARY KEY (id_livraria);
 @   ALTER TABLE ONLY public.livraria DROP CONSTRAINT livraria_pkey;
       public            postgres    false    219            �           2606    32856    livros livros_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.livros
    ADD CONSTRAINT livros_pkey PRIMARY KEY (id_livro);
 <   ALTER TABLE ONLY public.livros DROP CONSTRAINT livros_pkey;
       public            postgres    false    217            �           2606    32891    venda venda_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (id_venda);
 :   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_pkey;
       public            postgres    false    225            �           2606    32884    vendedor vendedor_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.vendedor
    ADD CONSTRAINT vendedor_pkey PRIMARY KEY (id_vendedor);
 @   ALTER TABLE ONLY public.vendedor DROP CONSTRAINT vendedor_pkey;
       public            postgres    false    223            �           2606    32857    livros livros_id_autor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.livros
    ADD CONSTRAINT livros_id_autor_fkey FOREIGN KEY (id_autor) REFERENCES public.autor(id_autor);
 E   ALTER TABLE ONLY public.livros DROP CONSTRAINT livros_id_autor_fkey;
       public          postgres    false    217    215    3205            �           2606    32907    venda venda_id_cliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);
 E   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_id_cliente_fkey;
       public          postgres    false    225    3211    221            �           2606    32892    venda venda_id_livraria_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_id_livraria_fkey FOREIGN KEY (id_livraria) REFERENCES public.livraria(id_livraria);
 F   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_id_livraria_fkey;
       public          postgres    false    3209    225    219            �           2606    32897    venda venda_id_livro_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_id_livro_fkey FOREIGN KEY (id_livro) REFERENCES public.livros(id_livro);
 C   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_id_livro_fkey;
       public          postgres    false    217    3207    225            �           2606    32902    venda venda_id_vendedor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_id_vendedor_fkey FOREIGN KEY (id_vendedor) REFERENCES public.vendedor(id_vendedor);
 F   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_id_vendedor_fkey;
       public          postgres    false    223    3213    225            $   z   x�3�tq��tQ���u�444ԃb]CCΔ�̲���������\.N'G� G���
^�~��A��F�z`ll�kl�B�1������kP��B�h�#P�H��u��8sR�̎���� /�#�      *   U   x�-�1
�0@�99E�vH!���"�X'�)����{s�z�;����U!�d�����k8���-̬LliY3m#ï �<�      (   l   x�%��	�0F�4����.��A� �9u�9jx��	v�}E��v�K˭���M��6��x��p�a$R�V�"��	�t���������� բ��hV�oa����      &   [   x�3�4�tw�uU�wS���s�41�35�t�w�WpUv�su2\��OJ�p�r�p�x��+q���Y�r����* �@U1z\\\ E�C      .   $   x�3�4�4bcN#N##]C]K� �=... B�b      ,   n   x�M�A
�@F�ur�����O@\�u�Bmd�u!��� (�����6�u*K�۫��� t#�<���Q�9ҽ.��� bf��=�)�ť�5�X����=�R�����w�     