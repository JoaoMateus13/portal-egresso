# Docker com JAVA, MAVEN e POSTGRES

- **Para iniciar o projeto em modo de desenvolvimento:**
    ```bash
    git checkout {branch de desenvolvimento}
    docker-compose -f docker-compose-dev.yml up
    ```

- **Para parar o projeto em modo de desenvolvimento:**
    ```bash
    docker-compose -f docker-compose-dev.yml stop
    ```

- **Para iniciar o projeto em modo de produção:**
    ```bash
    git checkout main
    docker-compose -f docker-compose-prod.yml up
    ```

- **Para parar o projeto em modo de produção:**
    ```bash
    docker-compose -f docker-compose-prod.yml stop
    ```
