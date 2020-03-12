Damsel Utils

Вспомогательные методы для более удобной работы с Damsel

### Настройки

Добавить в `pom.xml` в зависимости

```
<dependency>
    <groupId>com.rbkmoney.adapter-thrift-lib</groupId>
    <artifactId>damsel-utils</artifactId>
    <version>${damsel-utils.version}</version>
</dependency>
```

В зависимостях также должны быть указаны
```
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

Несколько примеров различных структур:

неудачное завершения платежа
```
ProxyProviderPackageCreators.createProxyResultFailure(failure);
```

перенаправления пользователя на ACS
```
Integer timer = 600;
Intent intent = ProxyProviderPackageCreators.createIntentWithSuspendIntent(
    tag, timer, createPostUserInteraction(url, params)
);

ProxyProviderPackageCreators.createPaymentProxyResult(intent, state);
```
