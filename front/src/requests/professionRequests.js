import { baseURL } from "../utils/baseURL";

export async function getProfessions() {
  const response = await fetch(`${baseURL}/profession`);
  const data = await response.json();
  return data;
}
