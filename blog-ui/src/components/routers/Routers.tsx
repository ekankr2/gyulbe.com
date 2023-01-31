import React from 'react';
import { Route, Routes } from 'react-router-dom';
import MainPage from '../pages/MainPage';
import MainLayout from '../layouts/MainLayout';
import CreatePostPage from '../pages/post/CreatePostPage';
import PostDetailPage from '../pages/post/PostDetailPage';

const Routers = () => {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        <Route index element={<MainPage />} />
        <Route path="/post/create" element={<CreatePostPage />} />
        <Route path="/post/:id" element={<PostDetailPage />} />
      </Route>
    </Routes>
  );
};

export default Routers;
