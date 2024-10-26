create user storeusbuser with encrypted password '1234';
create database storeusb with owner storeusbuser;

create user {nombre_usuario} with encrypted password '{contraseña}';
create database {nombre_db} with owner {nombre_usuario};

grant all privileges on database {nombre_db} to {nombre_usuario};