import React from 'react';
import { useGetPostList } from '../../api/hooks/postHooks';
import { Link, useNavigate } from 'react-router-dom';

const MainPage = () => {
  const { data: postList } = useGetPostList({});
  const navigate = useNavigate();

  return (
    <section className="body-font overflow-hidden text-gray-600">
      <article className="container mx-auto px-10 py-24">
        <div className="-my-8 divide-y-2 divide-gray-100">
          {postList &&
            postList.content.map((post) => (
              <div
                onClick={() => navigate(`/post/${post.id}`)}
                key={post.id}
                className="group flex cursor-pointer flex-wrap py-8 md:flex-nowrap"
              >
                <div
                  className="mb-6 flex w-full flex-col overflow-hidden rounded-xl transition-transform duration-300 ease-in-out
                group-hover:-translate-y-2 md:mr-[48px] md:mb-0 md:h-[240px] md:w-[240px] md:flex-shrink-0"
                >
                  <img className="h-full w-full" src="/sample-img.jpg" alt="main-image" />
                </div>
                <div className="flex flex-col justify-center md:px-[20px]">
                  <h2
                    className="title-font mb-2 text-4xl font-[600] text-gray-900 transition-colors
                  duration-300 ease-in-out group-hover:text-violet-700"
                  >
                    Meditation bushwick direct trade taxidermy shaman
                  </h2>
                  <p className="leading-relaxed">
                    Glossier echo park pug, church-key sartorial biodiesel vexillologist pop-up snackwave ramps
                    cornhole. Marfa 3 wolf moon party messenger bag selfies, poke vaporware kombucha lumbersexual pork
                    belly polaroid hoodie portland craft beer.
                  </p>
                  <span className="mt-1 text-sm text-gray-500">12 Jun 2019</span>
                </div>
              </div>
            ))}
        </div>
      </article>
    </section>
  );
};

export default MainPage;
