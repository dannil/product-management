import { AddProduct, Color, Product, Type } from '../types/product';

const API_URL = import.meta.env.VITE_APP_API_URL ?? 'http://localhost:8080/api';

enum ViewType {
  NORMAL = 'normal',
  FLAT = 'flat'
};

export const getProducts = async (viewType: ViewType = ViewType.NORMAL): Promise<Product[]> => {
  const response = await fetch(`${API_URL}/products?viewType=${viewType.toString().toLowerCase()}`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  });
  if (response.ok) {
    return response.json();
  }
  throw new Error(`API returned unexpected status code: ${response.status.toString()}`);
};

export const addProduct = async (product: AddProduct): Promise<boolean> => {
  const response = await fetch(`${API_URL}/products`, {
    method: 'POST',
    body: JSON.stringify(product),
    headers: {
      'Content-Type': 'application/json'
    }
  });
  if (response.ok) {
    return true;
  }
  throw new Error(`API returned unexpected status code: ${response.status.toString()}`);
};

export const getColors = async (): Promise<Color[]> => {
  const response = await fetch(`${API_URL}/colors`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  });
  if (response.ok) {
    return response.json();
  }
  throw new Error(`API returned unexpected status code: ${response.status.toString()}`);
};

export const getTypes = async (): Promise<Type[]> => {
  const response = await fetch(`${API_URL}/types`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  });
  if (response.ok) {
    return response.json();
  }
  throw new Error(`API returned unexpected status code: ${response.status.toString()}`);
};
