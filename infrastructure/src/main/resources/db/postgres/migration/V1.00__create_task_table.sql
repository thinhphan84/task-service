CREATE TABLE task (
                      id UUID PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      due_date TIMESTAMP,
                      status VARCHAR(20) NOT NULL,
                      priority VARCHAR(20) NOT NULL,
                      created_at TIMESTAMP NOT NULL,
                      updated_at TIMESTAMP,
                      is_deleted bool
);
