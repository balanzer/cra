

/* Insert data to requester table */
insert into requester (id, created_by, created_date, updated_date, updated_by, email, firstname, lastname, phonenumber) values (1, 'varathm', null, null, 'varathm', 'm.v@ihg.com', 'murali', 'varath', '123');

/* Insert data to campagign table */

insert into campaign (id, admin_comments, created_by, created_date, updated_date, updated_by, desc, name, status, director_comments, end_date, estimated_revenue, existing_pixel_requires_update, regional_director, special_instructions, start_date, vendor_has_campaign, requester_id) values (1, 'Admin : Murali - Approved this campaign Request', 'varathm', sysdate, sysdate, 'varathm', 'Campaign Information goes here', 'Facebook global pixel', 'ACTIVE', 'Director approved', sysdate, '1.5 Mil USD', 'N', 'm@ihg.com', 'N/A', sysdate, 'N', 1);
