export type Type = {
  id: number;
  name: string;
};

export type Color = {
  id: number;
  name: string;
};

export type Product = {
  id: number;
  name: string;
  type?: Type;
  colors?: Color[];
};
