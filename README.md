# adapter-thrift-lib

Вспомогательные библиотеки для трифтовых протоколов


### Разработчики

- [Anatoly Cherkasov](https://github.com/avcherkasov)


### Описание:


##### Damsel Utils

1. [damsel-utils](damsel-utils/README.md)


### Выпуск новой версии

Версии _adapter-thrift-lib-pom_ и всех его модулей должны совпадать, для этого перед началом работы над новой версией библиотеки нужно увеличить версию _adapter-thrift-lib-pom_ и в корневой директории проекта выполнить команду:
```
mvn versions:update-child-modules -DgenerateBackupPoms=false
```

Параметр `generateBackupPoms` можно опустить, если нужны резервные копии изменяемых файлов.
