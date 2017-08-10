export interface FieldInformation {
  fieldName: string;
  mandatory: boolean;
  minimumLength?: number;
  maximumLength?: number;
  matchesPattern?: string;
  defaultValue?: string;
}
