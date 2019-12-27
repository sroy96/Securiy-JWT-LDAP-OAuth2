INSERT INTO users (username, password, enabled)
    values ('user',
        'userpass',
        true
    );

INSERT INTO users(username,password,enabled)
    values ('Saurav',
      'lock',
      true
      );

    INSERT INTO users (username, password, enabled)
    values ('admin',
        'adminpass',
        true
    );

    INSERT INTO authorities (username, authority)
    values ('user', 'ROLE_USER');

     INSERT INTO authorities (username, authority)
    values ('admin', 'ROLE_ADMIN')