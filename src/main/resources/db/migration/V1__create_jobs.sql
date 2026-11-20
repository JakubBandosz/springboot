CREATE TABLE jobs (
                      id        BIGSERIAL PRIMARY KEY,
                      type      VARCHAR(100) NOT NULL,
                      payload   TEXT,
                      status    VARCHAR(20)  NOT NULL DEFAULT 'PENDING',
                      attempts  INT          NOT NULL DEFAULT 0,
                      run_at    TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE INDEX idx_jobs_pending ON jobs (run_at) WHERE status = 'PENDING';