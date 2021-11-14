CREATE SEQUENCE BANCANDES_SEQUENCE;

CREATE TABLE A_ADMINISTRADOR
	(LOGIN VARCHAR2(255 BYTE),
	CREDENCIALES VARCHAR2(255 BYTE) NOT NULL,
	CONSTRAINT A_ADMINISTRADOR_PK PRIMARY KEY (LOGIN));

CREATE TABLE A_CLIENTE
	(LOGIN VARCHAR2(255 BYTE),
	TIPOCLIENTE VARCHAR2(255 BYTE),
	CONSTRAINT A_CLIENTE_PK PRIMARY KEY (LOGIN));




CREATE TABLE A_ABRIRCUENTA
	(IDPUNTOATENCION NUMBER NOT NULL,
	LOGINCLIENTE VARCHAR2(255 BYTE) NOT NULL,
	NUMEROCUENTA NUMBER,
	FECHA DATE NOT NULL,
    TIPO VARCHAR2(255 BYTE),
	CONSTRAINT A_ABRIRCUENTA_PK PRIMARY KEY (IDPUNTOATENCION, LOGINCLIENTE,NUMEROCUENTA));



CREATE TABLE A_ABRIRCDT
    (IDPUNTOATENCION NUMBER NOT NULL,
	LOGINCLIENTE VARCHAR2(255 BYTE) NOT NULL,
	IDCDT NUMBER,
	FECHA DATE NOT NULL,
    CONSTRAINT A_ABRIRCDT_PK PRIMARY KEY (IDCDT));


CREATE TABLE A_CDT
    (ID NUMBER,
    MONTO NUMBER NOT NULL,
    FECHAVENCIMIENTO DATE NOT NULL,
    TASARENDIMIENTO NUMBER(4,2) NOT NULL,
    IDOFICINA NUMBER NOT NULL,
    LOGINCLIENTE VARCHAR2(255 BYTE) NOT NULL,
    CONSTRAINT A_CDT_PK PRIMARY KEY (ID));





CREATE TABLE A_CONSIGNARCUENTA
    (IDPUNTOATENCION NUMBER,
    LOGINCLIENTE VARCHAR2 (255 BYTE),
    NUMEROCUENTA NUMBER,
    FECHA DATE,
    MONTO NUMBER NOT NULL,
    CONSTRAINT A_CONSIGNAR_PK PRIMARY KEY (IDPUNTOATENCION, LOGINCLIENTE, NUMEROCUENTA, FECHA));




CREATE TABLE A_CERRARCDT
    (IDPUNTOATENCION NUMBER NOT NULL,
    LOGINCLIENTE VARCHAR2 (255 BYTE) NOT NULL,
    IDCDT NUMBER,
    CONSTRAINT A_CERRARCDT_PK PRIMARY KEY (IDCDT));





CREATE TABLE A_OFICINA
    (ID NUMBER,
    NOMBRE VARCHAR2(255 BYTE) NOT NULL,
    DIRECCION VARCHAR2 (255 BYTE) NOT NULL,
    LOGINGERENTEOFICINA VARCHAR2(255 BYTE) NOT NULL,
    CONSTRAINT A_OFICINA_PK PRIMARY KEY (ID));



CREATE TABLE A_PRESTAMO
    (ID NUMBER,
    TIPO VARCHAR2 (255 BYTE),
    MONTO NUMBER NOT NULL,
    SALDO NUMBER NOT NULL,
    INTERESES NUMBER NOT NULL,
    NUMEROCUOTAS NUMBER NOT NULL,
    DIAPAGOCUOTA NUMBER NOT NULL,
    VALORCUOTAMINIMA NUMBER NOT NULL,
    LOGINCLIENTE VARCHAR2 (255 BYTE) NOT NULL,
    CONSTRAINT A_PRESTAMO_PK PRIMARY KEY (ID));



CREATE TABLE A_OPERACIONACCION
    (IDPUNTOATENCION NUMBER,
    LOGINCLIENTE VARCHAR2(255 BYTE),
    NOMBREEMPRESA VARCHAR2(255 BYTE),
    PORCENTACCION NUMBER (4,2),
    FECHA DATE,
    TIPO VARCHAR2(255 BYTE),
    CONSTRAINT A_OPERACIONACCION_PK PRIMARY KEY (IDPUNTOATENCION,LOGINCLIENTE,NOMBREEMPRESA,PORCENTACCION,FECHA,TIPO));



CREATE TABLE A_RECHAZARPRESTAMO
    (IDPUNTOATENCION NUMBER NOT NULL,
    LOGINCLIENTE VARCHAR2(255 BYTE) NOT NULL,
    IDPRESTAMO NUMBER,
    FECHA DATE,
    CONSTRAINT A_RECHAZARPRESTAMO_PK  PRIMARY KEY(IDPRESTAMO));




CREATE TABLE A_DESACTIVARCUENTA
    (IDPUNTOATENCION NUMBER NOT NULL,
    LOGINCLIENTE VARCHAR2(255 BYTE) NOT NULL,
    NUMEROCUENTA NUMBER,
    LOGINGERENTEOFICINA VARCHAR2(255 BYTE),
    CONSTRAINT A_DESACTIVARCUENTA_PK PRIMARY KEY (IDPUNTOATENCION, LOGINCLIENTE, NUMEROCUENTA));





CREATE TABLE A_PAGOCUOTAEXTRAORDINARIA
    (IDPUNTOATENCION NUMBER NOT NULL,
    LOGINCLIENTE VARCHAR2(255 BYTE) NOT NULL,
    IDPRESTAMO NUMBER,
    VALORCUOTA NUMBER NOT NULL,
    FECHA DATE NOT NULL,
    CONSTRAINT AA_PAGOCUOTAEXTRAORDINARIA_PK PRIMARY KEY (LOGINCLIENTE, IDPRESTAMO, FECHA));





    create table A_USUARIO(
        login VARCHAR2(255 BYTE) primary key,
        numeroDocumento VARCHAR2(255 BYTE),
        tipoDocumento VARCHAR2(255 BYTE),
        clave VARCHAR2(255 BYTE) not null,  
        nombre VARCHAR2(255 BYTE) not null,
        direccion VARCHAR2(255 BYTE) not null,
        email VARCHAR2(255 BYTE) not null,
        telefono VARCHAR2(255 BYTE) not null,
        ciudad VARCHAR2(255 BYTE) not null,
        departamento VARCHAR2(255 BYTE) not null,
        codigoPostal VARCHAR2(255 BYTE) not null
    );


    create table A_GERENTEGENERAL(
        login VARCHAR2(255 BYTE) primary key
    );

    create table A_CUENTA(
        numeroUnico number primary key,
        tipo VARCHAR2(255 BYTE),
        saldo NUMBER,
        fechaCreacion DATE not null,
        idOficina NUMBER,
        loginCliente VARCHAR2(255 BYTE)
    );

    create table A_CERRARCUENTA(
        idPuntoAtencion number,
        loginCliente VARCHAR2(255 BYTE),
        numeroCuenta number,
        fecha date, 

        CONSTRAINT CERRARCUENTA_PK PRIMARY KEY(idPuntoAtencion, loginCliente, numeroCuenta, fecha)
    );

    create table A_RENOVARCDT(
        idPuntoAtencion number,
        loginCliente VARCHAR2(255 BYTE),
        numeroCuenta number,
        idcdt number,
        monto number,

        CONSTRAINT RENOVAR_PK PRIMARY KEY(idPuntoAtencion, loginCliente, numeroCuenta, monto)
    );

    create table A_CAJERO(
        login VARCHAR2(255 BYTE) primary key,
        puntoAtencion number not null 
    );

    create table A_ACCIONES(
        nombreEmpresa VARCHAR2(255 BYTE),
        accionesPropias number,
        loginCliente VARCHAR2(255 BYTE),

        CONSTRAINT ACCIONES_PK PRIMARY KEY(nombreEmpresa, accionesPropias, loginCliente)
    );

    create table A_TRANSFERENCIACUENTA(
        idPuntoAtencion number,
        loginCliente VARCHAR2(255 BYTE),
        numeroCuenta number,
        numeroCuentaDestino number,
        fecha date,
        monto number NOT NULL,

        CONSTRAINT TRANSFERENCIACUENTA_PK PRIMARY KEY(idPuntoAtencion, loginCliente, numeroCuenta, numeroCuentaDestino, fecha)
    );
    
    create table A_SOLICITARPRESTAMO(
        idPuntoAtencion number,
        loginCliente VARCHAR2(255 BYTE),
        idPrestamo number PRIMARY KEY,
        fecha date
    );

    create table A_PUNTODEATENCION(
        id number PRIMARY KEY,
        tipo VARCHAR2(255 BYTE),
        localizacion VARCHAR2(255 BYTE),
        idOficina number
    );

    create table A_ACTIVARCUENTA(
        idPuntoAtencion number,
        loginCliente VARCHAR2(255 BYTE),
        numeroCuenta number,

        CONSTRAINT ACTIVARCUENTA_PK PRIMARY KEY(idPuntoAtencion, loginCliente, numeroCuenta)
    );

    create table A_PAGOCUOTA(
        idPuntoAtencion number,
        loginCliente VARCHAR2(255 BYTE),
        idPrestamo number,
        valorCuota number,
        fecha date,

        CONSTRAINT PAGOCUOTA_PK PRIMARY KEY(loginCliente, idPrestamo, fecha)
        
    );

    create table A_APROBARPRESTAMO(
        idPuntoAtencion number PRIMARY KEY,
        loginCliente VARCHAR2(255 BYTE),
        idPrestamo number,
        fecha date
    );
    
    CREATE TABLE A_GERENTEOFICINA(
        LOGIN VARCHAR2(255 BYTE) primary key  
    );
    
    CREATE TABLE A_RECHAZARPRESTAMO
    (IDPUNTOATENCION NUMBER NOT NULL,
    LOGINCLIENTE VARCHAR2(255 BYTE) NOT NULL,
    IDPRESTAMO NUMBER,
    FECHA DATE,
    CONSTRAINT A_RECHAZARPRESTAMO_PK  PRIMARY KEY(IDPRESTAMO)
    );
    
    create table A_CERRARPRESTAMO(
        idPuntoAtencion number PRIMARY KEY,
        loginCliente VARCHAR2(255 BYTE),
        idPrestamo number,
        fecha date
    );
    
    
    create table A_ASOCIACIONCUENTA(
        loginJefe VARCHAR2(255 BYTE),
        loginEmpleado VARCHAR2(255 BYTE),
        numeroCuentaJefe number,
        numeroCuentaEmpleado number,
        salario number,
        frecuenciaDePago VARCHAR2(255 BYTE),
        
        CONSTRAINT A_ASOCIACIONCUENTA_PK  PRIMARY KEY(loginJefe,loginEmpleado)
    );
    
    ALTER TABLE A_ASOCIACIONCUENTA
    ADD CONSTRAINT FK_ASOCIACIONCUENTA_LJ
    FOREIGN KEY (loginJefe) REFERENCES A_CLIENTE(LOGIN)
    ON DELETE CASCADE
    ENABLE;
    
    ALTER TABLE A_ASOCIACIONCUENTA
    ADD CONSTRAINT FK_ASOCIACIONCUENTA_LE
    FOREIGN KEY (loginEmpleado) REFERENCES A_CLIENTE(LOGIN)
    ON DELETE CASCADE
    ENABLE;
    
    ALTER TABLE A_ASOCIACIONCUENTA
    ADD CONSTRAINT FK_ASOCIACIONCUENTA_CJ
    FOREIGN KEY (numeroCuentaJefe) REFERENCES A_CUENTA(NUMEROUNICO)
    ON DELETE CASCADE
    ENABLE;
    
    ALTER TABLE A_ASOCIACIONCUENTA
    ADD CONSTRAINT FK_ASOCIACIONCUENTA_CE
    FOREIGN KEY (numeroCuentaEmpleado) REFERENCES A_CUENTA(NUMEROUNICO)
    ON DELETE CASCADE
    ENABLE;
    
    ALTER TABLE A_CERRARPRESTAMO
    ADD CONSTRAINT FK_IDPUNTODEATENCION_CP
    FOREIGN KEY (idPuntoAtencion) REFERENCES A_PUNTODEATENCION(id)
    ENABLE;
    
    ALTER TABLE A_CERRARPRESTAMO
    ADD CONSTRAINT FK_LOGINCLIENTE_CP
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;

    ALTER TABLE A_CERRARPRESTAMO
    ADD CONSTRAINT FK_IDPRESTAMO_CP
    FOREIGN KEY (idPrestamo) REFERENCES A_PRESTAMO(id)
    ENABLE;
    
    
    
    --Otras restricciones
    
    ALTER TABLE A_CUENTA
    ADD CONSTRAINT FK_IDOFICINA 
    FOREIGN KEY (idOficina) REFERENCES A_OFICINA(id)
    ENABLE;

    ALTER TABLE A_CUENTA
    ADD CONSTRAINT FK_LOGINCLIENTE
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;


    ALTER TABLE A_CERRARCUENTA
    ADD CONSTRAINT FK_IDPUNTODEATENCION
    FOREIGN KEY (idPuntoAtencion) REFERENCES A_PUNTODEATENCION(id)
    ENABLE;

    ALTER TABLE A_CERRARCUENTA
    ADD CONSTRAINT FK_LOGINCLIENTEENCERRAR
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;
    
    ALTER TABLE A_RENOVARCDT
    ADD CONSTRAINT FK_IDPUNTODEATENCION_RENOVAR
    FOREIGN KEY (idPuntoAtencion) REFERENCES A_PUNTODEATENCION(id)
    ENABLE;

    ALTER TABLE A_RENOVARCDT
    ADD CONSTRAINT FK_LOGINCLIENTE_RENOVAR
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;

    ALTER TABLE A_RENOVARCDT
    ADD CONSTRAINT FK_IDCDT_RENOVAR
    FOREIGN KEY (idCDT) REFERENCES A_CDT(id)
    ENABLE;

    ALTER TABLE A_CAJERO
    ADD CONSTRAINT FK_PUNTODEATENCION_CAJERO
    FOREIGN KEY (puntoAtencion) REFERENCES A_PUNTODEATENCION(id)
    ENABLE;
    
    ALTER TABLE A_ACCIONES
    ADD CONSTRAINT FK_LOGINCLIENTE_ACCIONES
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;


    ALTER TABLE A_TRANSFERENCIACUENTA
    ADD CONSTRAINT FK_IDPUNTODEATENCION_TRANSFERENCIA
    FOREIGN KEY (idPuntoAtencion) REFERENCES A_PUNTODEATENCION(id)
    ENABLE;

    ALTER TABLE A_TRANSFERENCIACUENTA
    ADD CONSTRAINT FK_LOGINCLIENTE_TRANSFERENCIA
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;


    ALTER TABLE A_SOLICITARPRESTAMO
    ADD CONSTRAINT FK_IDPUNTODEATENCION_SOLICITARPRES
    FOREIGN KEY (idPuntoAtencion) REFERENCES A_PUNTODEATENCION(id)
    ENABLE;
    
    ALTER TABLE A_SOLICITARPRESTAMO
    ADD CONSTRAINT FK_LOGINCLIENTE_SOLICITARPRES
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;

    ALTER TABLE A_SOLICITARPRESTAMO
    ADD CONSTRAINT FK_IDPRESTAMO_SOLICITARPRES
    FOREIGN KEY (idPrestamo) REFERENCES A_PRESTAMO(id)
    ENABLE;


    ALTER TABLE A_PUNTODEATENCION
    ADD CONSTRAINT FK_IDOFICINA_PA
    FOREIGN KEY (idOficina) REFERENCES A_OFICINA(id)
    ENABLE;

    ALTER TABLE A_ACTIVARCUENTA
    ADD CONSTRAINT FK_LOGINCLIENTE_AC
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;
    
    ALTER TABLE A_PAGOCUOTA
    ADD CONSTRAINT FK_IDPUNTODEATENCION_PC
    FOREIGN KEY (idPuntoAtencion) REFERENCES A_PUNTODEATENCION(id)
    ENABLE;

    ALTER TABLE A_PAGOCUOTA
    ADD CONSTRAINT FK_LOGINCLIENTE_PC
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;

    ALTER TABLE A_PAGOCUOTA
    ADD CONSTRAINT FK_IDPRESTAMO_PC
    FOREIGN KEY (idPrestamo) REFERENCES A_PRESTAMO(id)
    ON DELETE CASCADE
    ENABLE;


    ALTER TABLE A_APROBARPRESTAMO
    ADD CONSTRAINT FK_IDPUNTODEATENCION_AP
    FOREIGN KEY (idPuntoAtencion) REFERENCES A_PUNTODEATENCION(id)
    ENABLE;
    
    ALTER TABLE A_APROBARPRESTAMO
    ADD CONSTRAINT FK_LOGINCLIENTE_AP
    FOREIGN KEY (loginCliente) REFERENCES A_CLIENTE(login)
    ENABLE;

    ALTER TABLE A_APROBARPRESTAMO
    ADD CONSTRAINT FK_IDPRESTAMO_AP
    FOREIGN KEY (idPrestamo) REFERENCES A_PRESTAMO(id)
    ON DELETE CASCADE
    ENABLE;


ALTER TABLE A_CLIENTE
	ADD CONSTRAINT CK_CLIENTE_TIPO
	CHECK (TIPOCLIENTE IN('NATURAL', 'JURIDICO'))
ENABLE;


ALTER TABLE A_ABRIRCUENTA
    ADD CONSTRAINT CK_ABRIRCUENTA_TIPO
    CHECK (TIPO IN('AHORROS', 'CORRIENTE', 'AFC'))
ENABLE;

ALTER TABLE A_ABRIRCUENTA
ADD CONSTRAINT FK_AC_CLIENTE_AC
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

--FK PUNTO DE ATENCION ABRR CUENTA
ALTER TABLE A_ABRIRCUENTA
ADD CONSTRAINT FK_AC_PUNTODEATENCION_AC
    FOREIGN KEY (IDPUNTOATENCION)
    REFERENCES A_PUNTODEATENCION(ID)
ENABLE;



ALTER TABLE A_ABRIRCDT
ADD CONSTRAINT FK_ACDT_CLIENTE_ACDT
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

--FK PUNTO DE ATENCION ABRIR CDT
ALTER TABLE A_ABRIRCDT
ADD CONSTRAINT FK_AC_PUNTODEATENCION
    FOREIGN KEY (IDPUNTOATENCION)
    REFERENCES A_PUNTODEATENCION(ID)
ENABLE;


 --FK OFICINA CDT
ALTER TABLE A_CDT
ADD CONSTRAINT FK_CDT_OFICINA
    FOREIGN KEY (IDOFICINA)
    REFERENCES A_OFICINA(ID)
ENABLE;

ALTER TABLE A_CDT
ADD CONSTRAINT FK_CDT_CLIENTE
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;   


ALTER TABLE A_CONSIGNARCUENTA
ADD CONSTRAINT FK_ACONSIGN_CLIENTE
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

--FK PUNTO DE ATENCION ABRR CUENTA
ALTER TABLE A_CONSIGNARCUENTA
ADD CONSTRAINT FK_ACONSIGN_PUNTODEATENCION
    FOREIGN KEY (IDPUNTOATENCION)
    REFERENCES A_PUNTODEATENCION(ID)
ENABLE;

ALTER TABLE A_CERRARCDT
ADD CONSTRAINT FK_ACERRARCDT_CLIENTE
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

--FK PUNTO DE ATENCION ABRR CUENTA
ALTER TABLE A_CERRARCDT
ADD CONSTRAINT FK_ACERRARCDT_PUNTODEATENCION
    FOREIGN KEY (IDPUNTOATENCION)
    REFERENCES A_PUNTODEATENCION(ID)
ENABLE;

ALTER TABLE A_CERRARCDT
ADD CONSTRAINT FK_ACERRARCDT_CDT
    FOREIGN KEY (IDCDT)
    REFERENCES A_CDT(ID)
ENABLE;

ALTER TABLE A_OFICINA
ADD CONSTRAINT FK_OFICINA_GERENTEOFICINA
    FOREIGN KEY (LOGINGERENTEOFICINA)
    REFERENCES A_GERENTEOFICINA(LOGIN)
ENABLE;


ALTER TABLE A_PRESTAMO
ADD CONSTRAINT FK_APRESTAMO_CLIENTE
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

ALTER TABLE A_PRESTAMO
    ADD CONSTRAINT CK_PRESTAMO_TIPO
    CHECK (TIPO IN('VIVIENDA', 'ESTUDIO', 'AUTOMOVIL', 'CALAMIDAD', 'LIBREINVERSION'))
ENABLE;


ALTER TABLE A_OPERACIONACCION
ADD CONSTRAINT FK_OPERACIONACCION_CLIENTE
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

--FK PUNTO DE ATENCION ABRR CUENTA
ALTER TABLE A_OPERACIONACCION
ADD CONSTRAINT FK_AOPERACIONACCION_PUNTODEATENCION
    FOREIGN KEY (IDPUNTOATENCION)
    REFERENCES A_PUNTODEATENCION(ID)
ENABLE;

ALTER TABLE A_OPERACIONACCION
ADD CONSTRAINT CK_PORCENTACCION
    CHECK (PORCENTACCION>0)
ENABLE;


ALTER TABLE A_RECHAZARPRESTAMO
ADD CONSTRAINT FK_RECHAZARPRESTAMO_CLIENTE
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

--FK PUNTO DE ATENCION ABRR CUENTA
ALTER TABLE A_RECHAZARPRESTAMO
ADD CONSTRAINT FK_RECHAZARPRESTAMO_PUNTODEATENCION
    FOREIGN KEY (IDPUNTOATENCION)
    REFERENCES A_PUNTODEATENCION(ID)
ENABLE;


ALTER TABLE A_RECHAZARPRESTAMO
ADD CONSTRAINT FK_RECHAZARPRESTAMO_PRESTAMO
    FOREIGN KEY (IDPRESTAMO)
    REFERENCES A_PRESTAMO(ID)
ENABLE;

ALTER TABLE A_DESACTIVARCUENTA
ADD CONSTRAINT FK_DESACTIVARCUENTA_CLIENTE
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

--FK PUNTO DE ATENCION ABRR CUENTA
ALTER TABLE A_DESACTIVARCUENTA
ADD CONSTRAINT FK_DESACTIVARCUENTA_PUNTODEATENCION
    FOREIGN KEY (IDPUNTOATENCION)
    REFERENCES A_PUNTODEATENCION(ID)
ENABLE;

ALTER TABLE A_DESACTIVARCUENTA
ADD CONSTRAINT FK_DESACTIVARCUENTA_GERENTEOFICINA
    FOREIGN KEY (LOGINGERENTEOFICINA)
    REFERENCES A_GERENTEOFICINA(LOGIN)
ENABLE;


ALTER TABLE A_PAGOCUOTAEXTRAORDINARIA
ADD CONSTRAINT FK_PAGOCUOTAEXTRAORDINARIA_CLIENTE
    FOREIGN KEY (LOGINCLIENTE)
    REFERENCES A_CLIENTE(LOGIN)
ENABLE;

--FK PUNTO DE ATENCION ABRR CUENTA
ALTER TABLE A_PAGOCUOTAEXTRAORDINARIA
ADD CONSTRAINT FK_PAGOCUOTAEXTRAORDINARIA_PA
    FOREIGN KEY (IDPUNTOATENCION)
    REFERENCES A_PUNTODEATENCION(ID)
ENABLE;

ALTER TABLE A_PAGOCUOTAEXTRAORDINARIA
ADD CONSTRAINT FK_PAGOCUOTAEXTRAORDINARIA_GERENTEOFICINA
    FOREIGN KEY (IDPRESTAMO)
    REFERENCES A_PRESTAMO(ID)
ENABLE;


ALTER TABLE A_USUARIO
ADD CONSTRAINT CEDULA_UNICA
UNIQUE (NUMERODOCUMENTO)
ENABLE;

ALTER TABLE A_USUARIO
ADD CONSTRAINT EMAIL_UNICO
UNIQUE (EMAIL)
ENABLE;

ALTER TABLE A_USUARIO
ADD CONSTRAINT TELEFONO_UNICO
UNIQUE (TELEFONO)
ENABLE;








