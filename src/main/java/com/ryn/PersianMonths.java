package com.ryn;

import java.util.Arrays;
import java.util.Optional;

public enum PersianMonths {
  MONTH_FARVARDIN("فروردین", 1),
  MONTH_ORDIBEHESHT("اردیبهشت", 2),
  MONTH_KHORDAD("خرداد", 3),
  MONTH_TIR("تیر", 4),
  MONTH_MORDAD("مرداد", 5),
  MONTH_SHAHRIVAR("شهریور", 6),
  MONTH_MEHR("مهر", 7),
  MONTH_ABAN("آبان", 8),
  MONTH_AZAR("آذر", 9),
  MONTH_DEY("دی", 10),
  MONTH_BAHMAN("بهمن", 11),
  MONTH_ESFAND("اسفند", 12);

  public final String monthPersianName;
  public final Integer monthNumber;

  private PersianMonths(String monthPersianName, Integer monthNumber) {
    this.monthNumber = monthNumber;
    this.monthPersianName = monthPersianName;
  }

  public Integer getMonthNumber() {
    return monthNumber;
  }

  public String getMonthName() {
    return monthPersianName;
  }

  public static Optional<PersianMonths> getMonthFromInt(Integer monthNumber) {
    return Arrays.stream(PersianMonths.values())
        .filter(month -> month.monthNumber == monthNumber)
        .findFirst();
  }
}
