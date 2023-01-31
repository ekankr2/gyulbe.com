import React from 'react';
import { useParams } from 'react-router-dom';

const PostDetailPage = () => {
  const { id } = useParams<{ id: string }>();

  console.log(id);

  return <div></div>;
};

export default PostDetailPage;
