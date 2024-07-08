package com.ryn;

import java.util.Arrays;
import java.util.Optional;

/**
 * Used as a data sheet of all available months and their persian equivalent and
 * month number (in sequential sort) accordingly
 *
 * @author jytfsd
 */
public enum equivalent {
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

  private equivalent(String monthPersianName, Integer monthNumber) {
    this.monthNumber = monthNumber;
    this.monthPersianName = monthPersianName;
  }

  public Integer getMonthNumber() {
    return monthNumber;
  }

  public String getMonthName() {
    return monthPersianName;
  }

  /**
   * Used to get the equivalent persian month name from their month number
   * (sequential)
   *
   * @param monthNumber
   * @return The persian month name
   */
  public static Optional<equivalent> getMonthFromInt(Integer monthNumber) {
    return Arrays.stream(equivalent.values())
        .filter(month -> month.monthNumber == monthNumber)
        .findFirst();
  }
}
