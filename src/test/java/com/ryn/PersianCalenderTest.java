package com.ryn;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class PersianCalenderTest {
  /**
   * Using an API it verifies that the month(name) and year are both assigned to
   * the correct month/year
   * * However the FormatStyle.SHORT is not tested as its assumed thats its
   * * correct for the other formats
   *
   * @throws IOException
   * @throws InterruptedException
   */
  @Test
  void testPersianStandardize() throws IOException, InterruptedException {
    // https://persian-calendar-api.sajjadth.workers.dev/
    Random random = new Random();
    PersianCalender app = new PersianCalender();
    List<FormatStyle> formats = List.of(
        FormatStyle.FULL,
        FormatStyle.LONG,
        FormatStyle.MEDIUM);
    HttpClient client = HttpClient.newHttpClient();

    for (int i = 0; i < 20; i++) {
      FormatStyle formatStyle = formats.get(random.nextInt(formats.size()));
      Integer year = random.nextInt(1970 - 620,
          Year.now(ZoneId.of("Asia/Tehran")).getValue() + 1 - 620);
      Integer yearMonths = random.nextInt(1, 12 + 1);
      Integer dayOfAMonth = random.nextInt(1, YearMonth.of(year, yearMonths).lengthOfMonth());
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(
              "https://persian-calendar-api.sajjadth.workers.dev/?year=%s&month=%s&day=%s".formatted(
                  year, yearMonths, dayOfAMonth)))
          .GET()
          .build();

      HttpResponse<String> response = client.send(request,
          HttpResponse.BodyHandlers.ofString());

      // Due to the lack of decent response from this API i cant actually properly
      // find a way to test the day

      String expected_month;
      // String expected_day;
      String expected_year;
      switch (formatStyle.name()) {
        case "FULL":
          // expected_day = app.persianStandardize(LocalDate.of(year, yearMonths,
          // dayOfAMonth),
          // Optional.of(FormatStyle.FULL)).split(" ")[1];
          expected_month = app.persianStandardize(LocalDate.of(year, yearMonths, dayOfAMonth),
              Optional.of(FormatStyle.FULL)).split(" ")[2];
          expected_year = app.persianStandardize(LocalDate.of(year, yearMonths, dayOfAMonth),
              Optional.of(FormatStyle.FULL)).split(" ")[3];
          break;
        case "MEDIUM":
          // expected_day = app.persianStandardize(LocalDate.of(year, yearMonths,
          // dayOfAMonth),
          // Optional.of(FormatStyle.MEDIUM)).split(" ")[0];
          expected_month = app.persianStandardize(LocalDate.of(year, yearMonths, dayOfAMonth),
              Optional.of(FormatStyle.MEDIUM)).split(" ")[1];
          expected_year = app.persianStandardize(LocalDate.of(year, yearMonths, dayOfAMonth),
              Optional.of(FormatStyle.MEDIUM)).split(" ")[2];
          break;
        case "LONG":
          // expected_day = app.persianStandardize(LocalDate.of(year, yearMonths,
          // dayOfAMonth),
          // Optional.of(FormatStyle.MEDIUM)).split(" ")[0];
          expected_month = app.persianStandardize(LocalDate.of(year, yearMonths, dayOfAMonth),
              Optional.of(FormatStyle.MEDIUM)).split(" ")[1];
          expected_year = app.persianStandardize(LocalDate.of(year, yearMonths, dayOfAMonth),
              Optional.of(FormatStyle.MEDIUM)).split(" ")[2];
          break;
        default:
          throw new AssertionError();
      }

      assertTrue(response.body().substring(1,
          response.body().indexOf("gregorian")).contains(expected_month));
      assertTrue(response.body().substring(1,
          response.body().indexOf("gregorian")).contains(expected_year));
    }
  }
}
