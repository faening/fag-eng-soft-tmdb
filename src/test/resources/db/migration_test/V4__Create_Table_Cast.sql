CREATE TABLE IF NOT EXISTS "cast"(
    id BIGINT NOT NULL AUTO_INCREMENT,
    adult BOOLEAN DEFAULT FALSE,
    gender TINYINT NOT NULL DEFAULT 0,
    tmdb_id INT NOT NULL,
    known_for_department VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    original_name VARCHAR(100) NOT NULL,
    popularity DOUBLE DEFAULT 0.0,
    profile_path VARCHAR(100),
    cast_id INT,
    tmdb_character VARCHAR(100),
    credit_id VARCHAR(100),
    tmdb_order INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    PRIMARY KEY (id)
);