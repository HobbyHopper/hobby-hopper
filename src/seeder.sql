use hobby_hopper_db;


INSERT INTO categories (category_name) VALUES ('indoor'),
                                              ('outdoor'),
                                              ('high activity'),
                                              ('moderate activity'),
                                              ('low activity');

INSERT INTO expertise (expertise,description) VALUES
                                                     ('beginner','I am still new to this hobby and would appreciate help and/or guidance'),
                                                     ('intermediate','I am comfortable with this hobby'),
                                                     ('advanced','I have am comfortable with this hobby and I am willing to help others learn');
INSERT INTO hobbies (hobby_name) VALUES ('painting'),
                                        ('fishing'),
                                        ('disk golf'),
                                        ('skating'),
                                        ('lawn darts'),
                                        ('collecting bottle caps'),
                                        ('dnd'),
                                        ('carpentry');

insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Alfa Charlie Romeo November Papa Uniform Zulu Sierra Delta Tango India Lima Echo Mike Juliett Kilo Victor Foxtrot', '5 Rusk Center', '2021-12-24 23:57:52', '2022-04-22 02:58:55', 'Change Traction Apparatus on Head', true, true, false, false, 'http://sakura.ne.jp/sit/amet.json?stibulum=a&vestibulum=pede&ante=posuere&ipsum=nonummy', '2021-06-16 00:50:12', '2021-08-26 23:09:31',5);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Echo Quebec November Romeo Victor India Zulu Bravo Golf Delta Kilo Charlie', '19190 Elgar Street', '2021-08-02 06:56:49', '2021-07-29 16:14:31', 'Drainage of Left Hand Muscle with Drain Dev, Open Approach', false, false, true, false, 'https://nydailynews.com/mattis/nibh.jsp?integer=enim&non=sit&velit=amet&donec=nunc&diam=viverra&neque=dapibus&vestibtis&aliquet=vel&ultrices=dapibus&erat=at&tortor=diam&sollicitudin=nam&mi=tristique&sit=tortor&amet=eu&lobortis=pede', '2022-06-01 07:11:38', '2021-07-20 04:27:15',4);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Foxtrot Hotel Zulu Lima India Alfa Juliett Romeo Bravo Sierra Golf Quebec Charlie Whiskey Uniform Tango Kilo November', '8 Eagan Trail', '2021-09-24 01:05:06', '2021-06-14 14:42:13', 'Destruction of Cecum, Percutaneous Endoscopic Approach', false, true, false, false, 'https://trellian.com/sit/amet/cursus.jpg?donec=magna&pharetra=bibendum&magna=imperdiet&vestibulum=nullam&aliquet=orci&ultrices=pede&erat=venenatium&molestie=sonascetur&nibh=ridiculus&in=mus&hac=vivamus&habitasse=vestibulum&platea=sagittis&dictumst=sapien', '2022-04-16 13:40:37', '2021-08-25 11:26:29',3);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'India Yankee Echo Whiskey X-ray Zulu Quebec Sierra Kilo Hotel', '9 Norway Maple Street', '2022-02-06 20:38:04', '2021-07-05 06:54:32', 'Excision of Supernumerary Breast, Percutaneous Approach', true, true, true, false, 'http://sun.com/vestibulum/sit/amet/cursus/id/turpis.jsp?interdum=et&venenatis=commodo&turpis=vulputate&enim=justo&blandit=in&mi=blandit&in=ultrices&porttitor=eniices&habitasse=phasellus&platea=id&dictumst=sapien&morbi=in&vestibulum=sapien&velit=iaculis', '2022-02-13 06:00:49', '2021-09-12 07:42:22',2);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Hotel Sierra Tango Kilo Bravo Charlie Victor Zulu Juliett November', '2584 Acker Plaza', '2021-12-27 19:08:43', '2022-05-11 11:51:16', 'Supplement L Ext Iliac Vein with Autol Sub, Perc Approach', false, false, true, false, 'https://goodreads.com/magnis/dis/parturient/montes/nascetur/ridiculus/mus.xml?ipsum=aucmpus=habitasse&semper=platea&est=dictumst&quam=morbi&pharetra=vestibulum&magna=velit&ac=id&consequat=pretium&metus=iaculis&sapien=diam', '2021-07-20 16:23:30', '2021-10-15 10:34:03',1);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Sierra Uniform Lima Whiskey Juliett Oscar Charlie Bravo Mike Tango November Kilo Alfa', '94116 Burrows Crossing', '2021-06-12 05:37:54', '2021-05-24 18:47:34', 'Insertion of Intralum Dev into R Radial Art, Open Approach', true, true, true, true, 'http://youtu.be/scelerisque/mauris.xml?faucibus=platea&orci=dictumst&luctus=etiam&et=faucibus&ultrices=cursus&posueum=pellentesque&imperdiet=quisque&nullam=porta&orci=volutpat&pede=erat&venenatis=quisque&non=erat&sodales=eros', '2021-07-11 07:14:44', '2021-06-02 11:40:30',1);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Juliett November Echo Mike Alfa Lima Golf Yankee Quebec Hotel Foxtrot Kilo Sierra Tango Oscar Zulu Romeo Charlie Uniform Delta', '2417 Dennis Avenue', '2021-12-11 13:03:03', '2021-11-21 04:59:32', 'Occlusion of L Radial Art with Intralum Dev, Perc Approach', false, false, false, true, 'http://fastcompany.com/nam/nulla.json?quis=nec&augul&ut=lectus&erat=in&curabitur=quam&gravida=fringilla&nisi=rhoncus&at=mauris&nibh=enim&in=leo&hac=rhoncus&habitasse=sed&platea=vestibulum&dictumst=sit&aliquam=amet&augue=cursus&quam=id', '2021-10-25 17:34:15', '2022-05-13 19:08:52',2);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Bravo Zulu Quebec Oscar Mike Victor Hotel Romeo Kilo Yankee X-ray India November Charlie', '233 Burning Wood Junction', '2022-03-28 04:20:00', '2021-07-01 07:22:19', 'Revision of Spacer in Cerv Jt, Perc Endo Approach', false, true, false, true, 'http://macromedia.com/eleifend/donec/ut/dolor.png?pede=dapibus&ac=duis&diam=at&cras=velit', '2021-05-30 06:21:09', '2022-05-27 15:20:46',3);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Mike Echo X-ray India Yankee Hotel Kilo Alfa Lima Bravo Victor Oscar Charlie Romeo Foxtrot Juliett Quebec Papa Golf', '20308 Nevada Point', '2022-05-03 09:08:18', '2022-03-14 13:59:14', 'Dilation of Face Artery with Intralum Dev, Open Approach', true, false, true, false, 'http://diigo.com/duis/faucibus/accumsan/odio.js?in=elit&hac=proin&habitasse=risus&platea=praesent&dictumst=lectus&etiam=vestibulum&faucibus=quam&cursus=sapien&urna=vamentum=ipsum&nullam=primis&varius=in&nulla=faucibus&facilisi=orci', '2022-05-30 13:13:32', '2021-06-13 23:33:57',4);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Tango Charlie Yankee Whiskey Zulu Oscar Golf Foxtrot Sierra Echo Lima Hotel Alfa Papa Romeo India November Victor Bravo Juliett', '834 Columbus Avenue', '2021-10-29 01:53:54', '2022-01-26 05:21:04', 'Drainage of Jejunum, Percutaneous Approach, Diagnostic', false, false, true, false, 'http://cpanel.net/augue/aliquam/erat/volutpat.html?eget=faucibus&orci=orci&vehicula=luctus&condimentum=et&curabitur=ultrices&in=posuere&libero=cubilia&ut=curae&massa=mauris', '2022-01-18 09:26:26', '2022-03-29 23:21:32',5);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Delta Golf India Mike November Quebec Kilo X-ray Whiskey Juliett Tango Alfa Echo Zulu', '303 Erie Court', '2022-06-08 06:45:53', '2021-11-30 04:08:06', 'Bypass Right Vas Deferens to L Epidid, Perc Endo Approach', false, false, false, true, 'http://jugem.jp/quis/augue/luctus/tincidunt/nulla/mollis.aspx?consequat=in&dui=quis&nec=justs&sed=nec&vestibulum=molestie&sit=sed&amet=justo&cursus=pellentesque&id=viverra&turpis=pede&integer=ac', '2022-04-04 01:32:57', '2021-09-28 13:49:48',5);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Juliett Charlie Delta Golf Bravo Yankee November Foxtrot Kilo Lima Oscar Echo Romeo', '763 Shopko Park', '2022-01-15 12:18:34', '2022-03-05 01:08:08', 'Restrict L Axilla Lymph w Extralum Dev, Perc Endo', true, true, true, true, 'https://yahoo.com/commodo/vulputate/justo/in/blandit.json?ultrices=donec&phasellus=ut&idm&eget=ante&orci=ipsum&vehicula=primis&condimentum=in&curabitur=faucibus&in=orci&libero=luctus&ut=et&massa=ultrices&volutpat=posuere', '2022-04-23 06:02:54', '2022-03-04 14:13:48',4);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Quebec Romeo Whiskey India Alfa Uniform Papa Oscar Bravo Delta Charlie', '6477 Columbus Crossing', '2022-02-23 11:57:56', '2021-05-23 03:16:52', 'Supplement R Foot Muscle with Synth Sub, Perc Endo Approach', true, false, true, true, 'https://meetup.com/mauris/vulputate/elementum/nullam/varius/nulla.jpg?magna=eros&at=viverra&nunc=eget&commodo=congue&placerat=eget&praesent=semper&blandit=rutrum&nam=nulla&nulla=nunc&integer=purus', '2022-05-28 08:46:59', '2021-07-07 14:16:39',3);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'November India Tango Sierra Oscar Quebec X-ray Mike Yankee Charlie Golf Foxtrot Kilo Lima Alfa Zulu Juliett Whiskey Romeo Bravo', '3727 Saint Paul Hill', '2022-01-19 05:15:29', '2021-08-21 19:36:46', 'Fusion 2-6 C Jt w Autol Sub, Post Appr P Col, Perc', true, false, false, true, 'http://upenn.edu/in.jsp?cubilia=laoreet&curae=ut&duis=rhoncus&faucibus=aliquet&accumsan=pulvinar&odio=sed&curabitur=nisl&convallis=nunc&duis=rhoncus&conseluctus=id&nec=nisl&molestie=venenatis&sed=lacinia&justo=aenean&pellentesque=sit', '2021-06-29 16:18:17', '2022-03-20 07:38:23',2);
insert into events ( event_name, address, created_event, updated_event, event_description, is_age_restricted, is_reported, rsvp_able, is_public, reference_url, start_date, end_date,category_id) values ( 'Delta Zulu Victor X-ray Sierra India Echo Oscar Mike Charlie Golf Lima Foxtrot Kilo', '0301 Meadow Ridge Avenue', '2021-06-05 05:10:08', '2021-07-06 02:31:07', 'Phys Rehab & Diag Audiology, Rehab, ADL Trmt', true, true, true, true, 'http://engadget.com/orci.png?at=leo&nulla=rhoncus&suspendisse=sed&potenti=vestibulum&cras=sit&in=amet&purus=cursus&eu=id&magna=turpis&id=tortor&nisl=id&venenatis=nulla&lacinia=ultrices&aenean=aliquet&sit=maecenas&amet=leo&justo=odio&morbi=condimentum', '2021-11-29 19:32:40', '2021-10-18 09:28:16',1);

insert into users ( dob, email, image, is_admin, location, password, username) values ( '2022-04-06', 'dskelly0@go.com', 'http://dummyimage.com/180x100.png/dddddd/000000', false, '3965 Summerview Drive', 'TEC5vc34AsTa', 'ceburne0');
insert into users ( dob, email, image, is_admin, location, password, username) values ( '2021-10-17', 'sduckwith1@angelfire.com', 'http://dummyimage.com/147x100.png/5fa2dd/ffffff', true, '960 Mendota Hill', 'UJ68ILBBR1oV', 'ahansford1');
insert into users ( dob, email, image, is_admin, location, password, username) values ('2022-05-19', 'ishepeard2@geocities.com', 'http://dummyimage.com/190x100.png/5fa2dd/ffffff', true, '6 Jana Trail', 'eWhDktBMIR', 'yhavick2');
insert into users ( dob, email, image, is_admin, location, password, username) values ( '2022-04-24', 'eaxelbee3@illinois.edu', 'http://dummyimage.com/241x100.png/cc0000/ffffff', true, '043 Emmet Road', 'MCDeCs9zkGe1', 'hbreeton3');
insert into users ( dob, email, image, is_admin, location, password, username) values ( '2021-10-23', 'jwoloschin4@cornell.edu', 'http://dummyimage.com/110x100.png/dddddd/000000', false, '25 Rieder Road', 'klXsfPO8piua', 'jbilton4');