import { Product } from '../types/product';

const API_URL = import.meta.env.API_URL ?? 'http://localhost:8080/api';

enum ViewType {
  NORMAL = 'normal',
  FLAT = 'flat'
}

export const getProducts = async (viewType: ViewType = ViewType.NORMAL): Promise<Product[]> => {
  const response = await fetch(`${API_URL}/products?viewType=${viewType.toString().toLowerCase()}`);
  if (response.ok) {
    return response.json();
  }
  throw new Error(response.status.toString());
};
