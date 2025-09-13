create database DB_Repuestos;
use DB_Repuestos;

Create table categoria (
    id int auto_increment primary key,
    nombre varchar(100) not null
);

create table cliente (
    id int auto_increment primary key,
    nombre varchar(100) not null,
    email varchar(100),
    telefono varchar(20)
);


create table proveedor (
    id int auto_increment primary key,
    nombre varchar(100) not null,
    telefono varchar(20),
    email varchar(100)
);

create table repuesto (
    id int auto_increment primary key,
    nombre varchar(100) not null,
    precio decimal(10,2),
    stock int,
    categoriaid int,
    proveedorid int,
    foreign key (categoriaid) references categoria(id),
    foreign key (proveedorid) references proveedor(id)
);
Select * from categoria;
Select * from cliente;
Select * from proveedor;
Select * from repuesto;


