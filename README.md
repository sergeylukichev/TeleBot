# Telegram Bot as SpringBoot starter app

You have to change the the config values for `bot.token` and `bot.username` in the `application.yml` to the credentials of your bot and then you're ready to go.

To start in Docker container, first build the image:
```
docker build -t bot .
```
then run:
```
docker run --rm -it bot:latest
```