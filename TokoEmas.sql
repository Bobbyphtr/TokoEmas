CREATE DATABASE toko_emas;

CREATE TABLE kategori (
  id int(5) PRIMARY KEY AUTO_INCREMENT,
  nama varchar(50) NOT NULL
);

CREATE TABLE supplier(
  id int(5) PRIMARY KEY AUTO_INCREMENT,
  nama varchar(50) NOT NULL,
  alamat varchar(100) NOT NULL,
  no_telp varchar(25) NOT NULL UNIQUE
);

CREATE TABLE barang(
  id int(5) PRIMARY KEY AUTO_INCREMENT,
  nama varchar(50) NOT NULL,
  deskripsi varchar(100),
  berat numeric(9,3) NOT NULL,
  karat numeric(9,3) NOT NULL,
  status varchar(10) NOT NULL,
  tipe_barang varchar(10) NOT NULL,
  id_kategori int(5) NOT NULL,
  id_supplier int(5) NOT NULL,
  harga_beli int(10) NOT NULL,
  tanggal_beli DATE NOT NULL,

  CONSTRAINT ck_status CHECK(status in ('Terjual','Tersedia','Hilang')),
  CONSTRAINT ck_tipebarang CHECK(tipe_barang in ('Kuning','Putih')),
  CONSTRAINT fk_kategori FOREIGN KEY (id_kategori) REFERENCES kategori(id),
  CONSTRAINT fk_supplier FOREIGN KEY (id_supplier) REFERENCES supplier(id)
);

CREATE TABLE customer(
  id int(5) PRIMARY KEY AUTO_INCREMENT,
  nama varchar(50) NOT NULL,
  email varchar(50) NOT NULL UNIQUE,
  alamat varchar(100) NOT NULL,
  no_telp varchar(25) NOT NULL UNIQUE,
  status_loyal varchar(10) NOT NULL,
  bonus int(10),
  deskripsi_bonus varchar(100),

  CONSTRAINT ck_status_loyal CHECK(status_loyal in ('Loyal','NonLoyal'))
);

CREATE TABLE pekerja(
  id int(5) PRIMARY KEY AUTO_INCREMENT,
  nama varchar(50) NOT NULL,
  email varchar(50) NOT NULL UNIQUE,
  alamat varchar(100) NOT NULL,
  no_telp varchar(25) NOT NULL UNIQUE,
  gaji int(10) NOT NULL,
  posisi varchar(25) NOT NULL,
  reward int(10),
  deskripsi_reward varchar(100)
);

CREATE TABLE transaksi(
  id_barang int(5),
  id_customer int(5),
  id_pekerja int(5),
  metode_pembayaran varchar(10) NOT NULL,
  harga_jual int(10) NOT NULL,
  tanggal_jual DATE NOT NULL,

  CONSTRAINT pk_transaksi PRIMARY KEY (id_barang,id_customer,id_pekerja),
  CONSTRAINT ck_metode_pembayaran CHECK(metode_pembayaran in ('Debit','Kredit','Cash')),
  CONSTRAINT fk_barang FOREIGN KEY (id_barang) REFERENCES barang(id),
  CONSTRAINT fk_customer FOREIGN KEY (id_customer) REFERENCES customer(id),
  CONSTRAINT fk_pekerja FOREIGN KEY (id_pekerja) REFERENCES pekerja(id)
);
