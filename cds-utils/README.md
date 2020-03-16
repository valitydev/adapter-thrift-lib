CDS Utils

Вспомогательные методы для более удобной работы с CDS

### Настройки

Добавить в `pom.xml` в зависимости

```
<dependency>
    <groupId>com.rbkmoney.adapter-thrift-lib</groupId>
    <artifactId>cds-utils</artifactId>
    <version>${cds-utils.version}</version>
</dependency>
```

В зависимостях также должны быть указаны
```
<dependency>
    <groupId>com.rbkmoney</groupId>
    <artifactId>cds-proto</artifactId>
    <version>${cds-proto.version}</version>
</dependency>
<dependency>
    <groupId>com.rbkmoney</groupId>
    <artifactId>damsel</artifactId>
    <version>${damsel.version}</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>${jackson-databind.version}</version>
</dependency>
```


### Использование

Создание структуры Auth3DS с заполненной cryptogram-ой
```
CdsPackageCreators.createAuth3DS(cryptogram);
```
