import { baseURL } from "../utils/baseURL";

export async function getTalents() {
  const response = await fetch(`${baseURL}/talent`);
  const data = await response.json();
  return data;
}
