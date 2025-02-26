import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ProductCreate from './components/ProductCreate';
import './index.css';
import ProductLayout from './layout/ProductLayout';
import ProductListing from './components/ProductListing';

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/">
          <Route element={<ProductLayout />}>
            <Route path="product" element={<ProductListing />} />
            <Route path="product/new" element={<ProductCreate />} />
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>
);
