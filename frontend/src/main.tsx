import './index.css';
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ProductCreate from './components/product/ProductCreate';
import MainLayout from './layout/MainLayout';
import ProductListing from './components/product/ProductListing';

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/">
          <Route element={<MainLayout />}>
            <Route path="product" element={<ProductListing />} />
            <Route path="product/new" element={<ProductCreate />} />
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>
);
