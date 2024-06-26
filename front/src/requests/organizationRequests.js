import { baseURL } from "../utils/baseURL";

export async function getCompanies() {
  const response = await fetch(`${baseURL}/company`);
  const data = await response.json();
  return data;
}
