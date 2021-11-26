--For creating roles
INSERT INTO `mydb`.`role` (`role_id`, `name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `mydb`.`role` (`role_id`, `name`) VALUES ('2', 'ROLE_USER');

--For creating User
INSERT INTO `mydb`.`appuser` (`appuser_id`, `dob`, `email`, `firstname`, `gender`, `password`, `username`) VALUES ('1', '1996-06-20 00:00:00', 'admin@app.com', 'SuperAdmin', 'M', '$2a$10$KqItcRgNjSO8iZMcEAIOuO4RBc8eNqr16XR4NGxLvu9kYO95xvPtG', 'superadmin');

-- For mapping user with role
INSERT INTO `mydb`.`user_roles` (`appuser_id`, `role_id`) VALUES ('1', '1');
