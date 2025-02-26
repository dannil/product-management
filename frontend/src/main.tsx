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
        <Route path="/" element={<MainLayout />}>
          <Route index element={<ProductListing />} />
          <Route path="/new" element={<ProductCreate />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>
);
