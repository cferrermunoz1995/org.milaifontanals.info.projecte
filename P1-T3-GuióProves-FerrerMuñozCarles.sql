insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Cim', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Llac', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Riu', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Cascada', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Font', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Cova', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Trencall', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Aparcament', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Càmping', null);
insert into TIPUS (id_tipus, nom_tipus, icona_tipus) values (null, 'Parada de transport públic', null);

insert into USUARI (email_usuari, login_usuari, contrasenya_usuari) values ('cferrer1', 'cferrer1', 'f2b3df767a58b4cb680e6e1d88fdb031e40de6ee83cc286d6c58f8e6d434294a');
insert into USUARI (email_usuari, login_usuari, contrasenya_usuari) values ('cferrer2', 'cferrer2', 'e6fd7c1e20330533f32924314dc90e44b4cfc4c3d5d98c613af58c833446f689');
insert into USUARI (email_usuari, login_usuari, contrasenya_usuari) values ('cferrer3', 'cferrer3', 'c101700a968933284c8475e6d8c48967eec0dd2d53f3e8585b213f6719f0068c');
insert into USUARI (email_usuari, login_usuari, contrasenya_usuari) values ('cferrer4', 'cferrer4', '373bcddd6bf8905f45bf07a4b3270a47ca9a0658b996f94ab71f3172c208ef47');

insert into RUTA (id_ruta, titol_ruta, descrip_ruta, text_long_ruta, distancia_ruta, temps_ruta, desn_pos_ruta, desn_neg_ruta, dificultat_ruta, id_usuari_ruta) 
values (null, 'Ruta 1', 'Descripció ruta 1', 'Ruta 1 - València', 10, 2, 100, 100, 1, 'cferrer1');
insert into RUTA (id_ruta, titol_ruta, descrip_ruta, text_long_ruta, distancia_ruta, temps_ruta, desn_pos_ruta, desn_neg_ruta, dificultat_ruta, id_usuari_ruta) 
values (null, 'Ruta 2', 'Descripció ruta 2', 'Ruta 2 - Alacant', 10, 2, 100, 100, 4, 'cferrer1');
insert into RUTA (id_ruta, titol_ruta, descrip_ruta, text_long_ruta, distancia_ruta, temps_ruta, desn_pos_ruta, desn_neg_ruta, dificultat_ruta, id_usuari_ruta) 
values (null, 'Ruta 3', 'Descripció ruta 3', 'Ruta 3 - Castelló', 10, 2, 100, 100, 2, 'cferrer3');

insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 1, 'Punt 1 - Ruta 1', 'Punt 1 - Ruta 1', null, 12.1, 13.1, 1, 3.1);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 1, 'Punt 2 - Ruta 1', 'Punt 2 - Ruta 1', null, 12, 13, 2, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 1, 'Punt 3 - Ruta 1', 'Punt 3 - Ruta 1', null, 12, 13, 3, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 1, 'Punt 4 - Ruta 1', 'Punt 4 - Ruta 1', null, 12, 13, 4, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 1, 'Punt 5 - Ruta 1', 'Punt 5 - Ruta 1', null, 12, 13, 5, 3);

insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 2, 'Punt 1 - Ruta 2', 'Punt 1 - Ruta 2', null, 12, 13, 1, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 2, 'Punt 2 - Ruta 2', 'Punt 2 - Ruta 2', null, 12, 13, 2, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 2, 'Punt 3 - Ruta 2', 'Punt 3 - Ruta 2', null, 12, 13, 3, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 2, 'Punt 4 - Ruta 2', 'Punt 4 - Ruta 2', null, 12, 13, 4, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 2, 'Punt 5 - Ruta 2', 'Punt 5 - Ruta 2', null, 12, 13, 5, 3);

insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 3, 'Punt 1 - Ruta 3', 'Punt 1 - Ruta 3', null, 12, 13, 1, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 3, 'Punt 2 - Ruta 3', 'Punt 2 - Ruta 3', null, 12, 13, 2, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 3, 'Punt 3 - Ruta 3', 'Punt 3 - Ruta 3', null, 12, 13, 3, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 3, 'Punt 4 - Ruta 3', 'Punt 4 - Ruta 3', null, 12, 13, 4, 3);
insert into PUNT (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values
(null, 3, 'Punt 5 - Ruta 3', 'Punt 5 - Ruta 3', null, 12, 13, 5, 3);

insert into COMENTARI (id_comen, text_comen, valor_info_comen, feta_comen, dific_comen, v_pais_comen, v_seg_comen, mom_temp_comen, id_usu_comen, id_ruta_comen) values
(null, 'Comentari 1 - Ruta 1', 1, 0, null, null, null, CURRENT_TIMESTAMP, 'cferrer2', 1);

insert into COMENTARI (id_comen, text_comen, valor_info_comen, feta_comen, dific_comen, v_pais_comen, v_seg_comen, mom_temp_comen, id_usu_comen, id_ruta_comen) values
(null, 'Comentari 1 - Ruta 2', 5, 1, 2, 3, 4, CURRENT_TIMESTAMP, 'cferrer2', 2);

commit;