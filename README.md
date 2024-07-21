[**Click for persian version of the documentation**](./README.FA.md)

# Description

As of now - This libary won't support arabic specific symbols even if it means removing it at run time; goverment applications should take note of this.

## Examples

```java
    PersianCalender persianCalender = new PersianCalender();
    System.out
                .println(persianCalender.persianStandardize(LocalDate.now(
                                    ZoneId.of("Asia/Tehran")),
                                             Optional.empty())); // ۲۰۲۴/۷/۸
```

```java
        PersianCalender persianCalender = new PersianCalender();
        System.out
                .println(persianCalender.persianStandardize(LocalDate.now(
                        ZoneId.of("Asia/Tehran")),
                            Optional.of(FormatStyle.FULL)));  // دوشنبه ۸ مهر ۲۰۲۴
```

```java
        PersianCalender persianCalender = new PersianCalender();
        System.out
                .println(persianCalender.persianStandardize(LocalDate.of(1403, 02, 8),
                        Optional.of(FormatStyle.MEDIUM))); // ۸ اردیبهشت ۱۴۰۳
```

```java
        PersianCalender persianCalender = new PersianCalender();
        System.out
                .println(persianCalender.persianStandardize(LocalDate.of(1403, 02, 8),
                        Optional.of(FormatStyle.LONG))); // ۸ اردیبهشت ۱۴۰۳
```

## Notices
- As mentioned above arabic specific symbols are removed and shall not be included.
- Java dates are supposed to be immutable thus there won't be any post formatting support. *Although it might be added*
- As required by all goverment applications - The code does follow ISO guidelines however in these examples or even terminal applications the format might be altered. This is not due to any formating errors.

## Features
 
- [x] Converting Month names
- [x] Converting Day & Month & Year following The Solar Hijri calender

## Dev Guide

- [x] Library must be efficient
- [x] Library testing must be done with an external API
- [x] Library must include proper documentation
- [x] Library must follow ISO standards
- [x] Library must follow all application specific style guides (SonarLint and Markdown)
