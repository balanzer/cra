export class RegexValues {
  static EMAIL_REGEX: any = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
  static ALPHA_ONLY: any = /^[a-zA-Z]+$/;
  static ALPHA_NUMERIC_ONLY: any = /^[a-zA-Z0-9]+$/;
}
