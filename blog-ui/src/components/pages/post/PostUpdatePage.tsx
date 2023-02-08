import React, { useState } from 'react';
import { usePostStore } from '../../../store/postStore';
import { PostKeys, useUpdatePost } from '../../../api/hooks/postHooks';
import { useNavigate } from 'react-router-dom';
import { useQueryClient } from '@tanstack/react-query';
import { PostInfo } from '../../../api/types';

const PostUpdatePage = () => {
  const navigate = useNavigate();
  const selectedPostId = usePostStore((state) => state.selectedPostId);
  const queryClient = useQueryClient();
  const currentPostInfo = queryClient.getQueryData<PostInfo>([PostKeys.postInfo, selectedPostId?.toString()]);
  const [title, setTitle] = useState('');
  const [subTitle, setSubtitle] = useState('');
  const [content, setContent] = useState('');
  const { mutate: updatePost } = useUpdatePost();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (selectedPostId) {
      updatePost(
        { title: title, subTitle: subTitle, content: content, id: selectedPostId },
        {
          onSuccess: () => {
            alert('성공하였습니다.');
            queryClient.invalidateQueries([PostKeys.postInfo, selectedPostId]);
            return navigate('/');
          },
          onError: (error) => {
            return alert('등록 실패');
          },
        },
      );
    }
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
              required
              defaultValue={currentPostInfo?.title}
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
              required
              defaultValue={currentPostInfo?.subTitle}
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
              required
              defaultValue={currentPostInfo?.content}
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

export default PostUpdatePage;
