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

insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('184 Logan Street', 4, '2022-05-31', '2021-10-31', '05:02', 'Hidradenitis', 'Yodo', true, false, true, 'http://dummyimage.com/180x100.png/5fa2dd/ffffff', false, '2021-12-27', '07:45');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('7759 Jana Way', 5, '2021-06-25', '2021-07-11', '17:07', 'Hx-laryngeal malignancy', 'Demimbu', true, true, true, 'http://dummyimage.com/160x100.png/ff4444/ffffff', false, '2021-08-12', '16:51');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('8 Mcbride Court', 4, '2021-09-24', '2021-09-07', '01:06', 'Fx larynx/trachea-open', 'Blogpad', false, true, false, 'http://dummyimage.com/128x100.png/cc0000/ffffff', true, '2021-07-28', '09:30');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('8231 Toban Hill', 4, '2021-08-02', '2021-07-03', '10:46', 'Vasc dementia w depressn', 'Skidoo', true, false, true, 'http://dummyimage.com/172x100.png/ff4444/ffffff', true, '2022-06-15', '04:15');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('745 Sunfield Street', 4, '2021-11-26', '2022-06-03', '09:30', 'Acc poison-shellfish', 'Twimm', false, true, true, 'http://dummyimage.com/161x100.png/5fa2dd/ffffff', true, '2022-03-13', '12:24');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('415 Manley Trail', 3, '2022-04-18', '2022-02-07', '23:30', 'Whipple''s disease', 'Browsebug', true, true, false, 'http://dummyimage.com/125x100.png/5fa2dd/ffffff', true, '2021-08-22', '16:26');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('4755 Green Ridge Road', 5, '2021-10-23', '2021-07-10', '10:30', 'Ocular lacera w prolapse', 'Trilith', true, false, false, 'http://dummyimage.com/188x100.png/ff4444/ffffff', true, '2022-05-11', '15:22');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('8846 Forest Way', 5, '2022-04-16', '2022-01-13', '06:15', 'Nonvenomous snake bite', 'Leenti', true, false, false, 'http://dummyimage.com/173x100.png/dddddd/000000', false, '2022-01-24', '01:58');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('84 Ridge Oak Point', 3, '2021-10-16', '2021-12-23', '20:00', 'Ant disloc prox tibia-cl', 'Yacero', true, false, true, 'http://dummyimage.com/163x100.png/cc0000/ffffff', true, '2022-03-31', '16:33');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('7546 Evergreen Road', 2, '2021-08-29', '2022-06-09', '06:30', 'Hematocele, female NEC', 'Abata', false, true, false, 'http://dummyimage.com/244x100.png/ff4444/ffffff', true, '2022-03-17', '13:10');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('7 Maple Wood Parkway', 5, '2022-04-20', '2022-03-11', '00:17', 'Pigment epitheliopathy', 'Twiyo', true, true, true, 'http://dummyimage.com/159x100.png/ff4444/ffffff', true, '2021-11-30', '18:23');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('6218 Westerfield Place', 5, '2021-09-09', '2022-05-28', '03:59', 'Contusion shoulder & arm', 'Cogidoo', false, true, true, 'http://dummyimage.com/202x100.png/dddddd/000000', true, '2021-10-13', '02:18');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('4110 Atwood Plaza', 2, '2021-12-26', '2022-01-19', '04:06', 'Irreg sleep-wake rhy NOS', 'Skiptube', false, false, false, 'http://dummyimage.com/169x100.png/cc0000/ffffff', true, '2021-10-07', '02:16');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('5 Blackbird Parkway', 3, '2022-05-10', '2022-02-15', '07:35', 'Hx-cervical malignancy', 'Yoveo', false, false, true, 'http://dummyimage.com/120x100.png/5fa2dd/ffffff', false, '2022-05-10', '10:50');
insert into events (address, category_id, created_event, end_date, end_time, event_description, event_name, is_age_restricted, is_public, is_reported, reference_url, rsvp_able, start_date, start_time) values ('9560 Canary Pass', 3, '2021-06-21', '2022-04-12', '22:44', 'Mal carcinoid midgut NOS', 'Jetpulse', false, true, true, 'http://dummyimage.com/208x100.png/dddddd/000000', true, '2022-05-29', '20:46');

insert into users ( dob, email, image, is_admin, location, password, username) values ( '2022-04-06', 'dskelly0@go.com', 'http://dummyimage.com/180x100.png/dddddd/000000', true, '3965 Summerview Drive', '$2a$10$wNX9ZhyAqcDbvNw2PN/SjuxEitSmrq/Z/0MEvflshvDGH7CUAisSq', 'user1');
insert into users ( dob, email, image, is_admin, location, password, username) values ( '2021-10-17', 'sduckwith1@angelfire.com', 'http://dummyimage.com/147x100.png/5fa2dd/ffffff', FALSE, '960 Mendota Hill', '$2a$10$wNX9ZhyAqcDbvNw2PN/SjuxEitSmrq/Z/0MEvflshvDGH7CUAisSq', 'user2');
insert into users ( dob, email, image, is_admin, location, password, username) values ('2022-05-19', 'ishepeard2@geocities.com', 'http://dummyimage.com/190x100.png/5fa2dd/ffffff', FALSE, '6 Jana Trail', '$2a$10$wNX9ZhyAqcDbvNw2PN/SjuxEitSmrq/Z/0MEvflshvDGH7CUAisSq', 'user3');


insert into images (image_description, url, event_id) values
                                                             ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 1),
                                                             ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 1),
                                                             ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 1),
                                                             ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 1),
                                                             ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 1);
insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 2),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 2),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 2),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 2),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 2);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 3),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 3),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 3),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 3),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 3);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 4),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 4),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 4),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 4),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 4);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000',5),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff',5),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff',5),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 5),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg',5);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 6),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 6),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 6),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 6),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 6);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 7),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 7),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 7),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 7),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 7);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 8),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 8),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 8),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 8),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 8);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 9),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 9),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 9),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 9),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 9);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 10),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 10),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 10),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 10),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 10);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 11),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 11),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 11),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 11),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 11);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 12),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 12),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 12),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 12),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 12);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 13),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 13),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 13),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 13),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 13);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 14),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 14),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 14),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 14),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 14);

insert into images (image_description, url, event_id) values
                                                          ('very detailed and informative image description', 'http://dummyimage.com/110x100.png/dddddd/000000', 15),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 15),
                                                          ('very detailed and informative image description', 'http://dummyimage.com/241x100.png/cc0000/ffffff', 15),
                                                          ('very detailed and informative image description', 'https://cdn.mos.cms.futurecdn.net/v44n2mBJgaRoCkkFGjDtRP.jpeg', 15),
                                                          ('very detailed and informative image description', 'https://content.active.com/Assets/Active.com+Content+Site+Digital+Assets/Running/Articles/Benefits+of+Running/male+runner-carousel.jpg', 15);

INSERT INTO user_events (is_owner, event_id, expertise_id, user_id) VALUES (true,1,1,1),
                                                                           (true,2,1,1),
                                                                           (true,3,1,1),
                                                                           (true,4,1,1),
                                                                           (FALSE,5,1,1),
                                                                           (FALSE,5,1,1),
                                                                           (FALSE,6,1,1),
                                                                           (FALSE,7,1,1);



INSERT INTO event_hobbies (event_id, hobby_id) VALUES (2,1),
                                                   (2,2),
                                                   (2,3),
                                                   (4,3),
                                                   (4,4),
                                                   (4,1),
                                                   (6,4),
                                                   (6,8),
                                                   (6,2),
                                                   (8,6),
                                                   (8,7),
                                                   (8,3);




