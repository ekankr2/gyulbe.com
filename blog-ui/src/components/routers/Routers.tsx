import React from 'react';
import { Route, Routes } from 'react-router-dom';
import MainPage from '../pages/MainPage';
import MainLayout from '../layouts/MainLayout';
import PostCreatePage from '../pages/post/PostCreatePage';
import PostDetailPage from '../pages/post/PostDetailPage';
import PostUpdatePage from '../pages/post/PostUpdatePage';

const Routers = () => {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        <Route index element={<MainPage />} />
        <Route path="/post/create" element={<PostCreatePage />} />
        <Route path="/post/update" element={<PostUpdatePage />} />
        <Route path="/post/:id" element={<PostDetailPage />} />
      </Route>
    </Routes>
  );
};

export default Routers;
