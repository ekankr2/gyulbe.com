import React, { useState } from 'react';
import { createPost } from '../../../api/mainServices';
import { useNavigate } from 'react-router-dom';
import { useCreatePost } from '../../../api/hooks/postHooks';

const PostCreatePage = () => {
  const navigate = useNavigate();
  const [title, setTitle] = useState('');
  const [subTitle, setSubtitle] = useState('');
  const [content, setContent] = useState('');
  const { mutate: createPost } = useCreatePost();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    createPost(
      { title: title, subTitle: subTitle, content: content },
      {
        onSuccess: () => {
          alert('성공하였습니다.');
          return navigate('/');
        },
        onError: (error) => {
          return alert('등록 실패');
        },
      },
    );
  };

  return (
    <section className="flex h-screen items-center justify-center">
      <div className="block w-[600px] rounded-lg bg-white p-6 shadow-lg">
        <form onSubmit={(e) => handleSubmit(e)}>
          <div className="form-group mb-6">
            <label htmlFor="title" className="mb-2 inline-block text-gray-700">
              Title
            </label>
            <input
              type="text"
              onChange={(e) => setTitle(e.target.value)}
              className="m-0 block w-full rounded border border-solid border-gray-300 bg-white bg-clip-padding
               px-3 py-1.5 text-base font-normal text-gray-700 transition ease-in-out
        focus:border-blue-600 focus:bg-white focus:text-gray-700 focus:outline-none"
              placeholder="Enter Title"
            />
          </div>
          <div className="form-group mb-6">
            <label htmlFor="title" className="mb-2 inline-block text-gray-700">
              SubTitle
            </label>
            <input
              type="text"
              onChange={(e) => setSubtitle(e.target.value)}
              className="m-0 block w-full rounded border border-solid border-gray-300 bg-white bg-clip-padding
               px-3 py-1.5 text-base font-normal text-gray-700 transition ease-in-out
        focus:border-blue-600 focus:bg-white focus:text-gray-700 focus:outline-none"
              placeholder="Enter SubTitle"
            />
          </div>
          <div className="form-group mb-6">
            <label htmlFor="content" className="form-label mb-2 inline-block text-gray-700">
              Content
            </label>
            <textarea
              rows={5}
              onChange={(e) => setContent(e.target.value)}
              className="form-control m-0 block w-full rounded border border-solid border-gray-300 bg-white bg-clip-padding
        px-3 py-1.5 text-base font-normal text-gray-700 transition ease-in-out
        focus:border-blue-600 focus:bg-white focus:text-gray-700 focus:outline-none"
              placeholder="Content here"
            ></textarea>
          </div>
          <div className="flex w-full justify-center">
            <button
              type="submit"
              className=" rounded bg-blue-600 px-6 py-2.5 text-xs font-medium uppercase leading-tight text-white
      shadow-md transition duration-150 ease-in-out hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700
      focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg"
            >
              등록하기
            </button>
          </div>
        </form>
      </div>
    </section>
  );
};

export default PostCreatePage;
