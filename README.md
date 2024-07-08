
# Description

[**Click for persian version of the documentation**](./README.FA.md)
> Put it simply this is a library for the Persian Calender[Solar Hijri]
>
> This library is only for Iran persian and specific arabic stuff such as Hamza **ARE REMOVED AND SHALL NOT BE SUPPORTED**

## Examples
```java
    PersianCalender persianCalender = new PersianCalender();
    System.out
                .println(persianCalender.persianStandardize(LocalDate.now(ZoneId.of("Asia/Tehran")), Optional.empty())); // ۲۰۲۴/۷/۸
```
```java
        PersianCalender persianCalender = new PersianCalender();
        System.out
                .println(persianCalender.persianStandardize(LocalDate.now(ZoneId.of("Asia/Tehran")),
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

## Features

### As regards to foarmatting the dates with this libary its simply not possible at the momment cause this is just meant to convert dates rather than the pre-existing crap libaries that are just forkes of the LocalDate libary so a big huge code mess with no reliablity and i'll work on that

- [] Converting Month names
- [x] Converting Day & Month & Year following The Solar Hijri calender
- [] Convert the local time of a specific time zone to Solar Hijri



## Dev Guide

- [x] Library must be efficient
- [x] Library testing must be done with API
- [x] Library must include proper documentation
- [x] Library must include up to date Java APIs
- [x] Library must follow ISO standards
- [x] Library must account for leap years
