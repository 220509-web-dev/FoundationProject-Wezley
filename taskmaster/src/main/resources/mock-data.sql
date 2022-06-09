set search_path to taskmaster;

insert into users
values
    ('91e534f0-7065-43d6-bb9f-c6012361d41b', 'Wezley', 'Singleton', 'wezley.singleton@revature.com', 'wsingleton', 'revature'),
    ('4e4e79be-86de-4fd2-8d0e-9c07bb7e1708', 'Alice', 'Anderson', 'alice.anderson@revature.com', 'aanderson', 'password');

insert into tasks
values
    ('3f3e79be-86de-4fd2-8d0e-9c07bb7e1231', 'Task 1 Title', 'Task 1 Extended Description', 8, '91e534f0-7065-43d6-bb9f-c6012361d41b', '91e534f0-7065-43d6-bb9f-c6012361d41b', 'random-label'),
    ('3f3e79be-86de-4fd2-8d0e-9c07bb7e1232', 'Task 2 Title', 'Task 2 Extended Description', 5, '91e534f0-7065-43d6-bb9f-c6012361d41b', '91e534f0-7065-43d6-bb9f-c6012361d41b', 'random-label'),
    ('3f3e79be-86de-4fd2-8d0e-9c07bb7e1233', 'Task 3 Title', 'Task 3 Extended Description', 13, '4e4e79be-86de-4fd2-8d0e-9c07bb7e1708', '4e4e79be-86de-4fd2-8d0e-9c07bb7e1708', 'random-label'),
    ('3f3e79be-86de-4fd2-8d0e-9c07bb7e1234', 'Task 4 Title', 'Task 4 Extended Description', 21, '4e4e79be-86de-4fd2-8d0e-9c07bb7e1708', '4e4e79be-86de-4fd2-8d0e-9c07bb7e1708', 'random-label');