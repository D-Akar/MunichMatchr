<template>
  <div class="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
    <div class="sm:mx-auto sm:w-full sm:max-w-sm">
      <img
        class="mx-auto h-10 w-auto"
        src="https://tailwindui.com/plus/img/logos/mark.svg?color=indigo&shade=600"
        alt="Your Company"
      />
      <h2 class="mt-10 text-center text-2xl/9 font-bold tracking-tight text-gray-900">
        Take the next step and <br />help bring Munich tgoether!
      </h2>
    </div>

    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
      <form class="space-y-6" action="#" method="POST">
        <div class="flex flex-row space-x-4 w-full justify-between">
          <div class="flex-1">
            <label for="firstName" class="block text-sm/6 font-medium text-gray-900"
              >First Name</label
            >
            <div class="mt-2">
              <input
                id="firstName"
                name="firstName"
                required="true"
                class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm/6"
              />
            </div>
          </div>
          <div class="flex-1">
            <label for="lastName" class="block text-sm/6 font-medium text-gray-900"
              >Last Name</label
            >
            <div class="mt-2">
              <input
                id="lastName"
                name="lastName"
                required="true"
                class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm/6"
              />
            </div>
          </div>
        </div>
        <div>
          <label for="email" class="block text-sm/6 font-medium text-gray-900"
            >Email address</label
          >
          <div class="mt-2">
            <input
              id="email"
              name="email"
              type="email"
              autocomplete="email"
              required="true"
              class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm/6"
            />
          </div>
        </div>

        <div>
          <div class="flex items-center justify-between">
            <label for="password" class="block text-sm/6 font-medium text-gray-900"
              >Password</label
            >
            <div class="text-sm">
              <a href="#" class="font-semibold text-indigo-600 hover:text-indigo-500"
                >Forgot password?</a
              >
            </div>
          </div>
          <div class="mt-2">
            <input
              id="password"
              name="password"
              type="password"
              autocomplete="current-password"
              required="true"
              class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm/6"
            />
          </div>
        </div>

        <div>
          <button
            type="submit"
            class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm/6 font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
          >
            Register
          </button>
        </div>
      </form>

      <p class="mt-10 text-center text-sm/6 text-gray-500">
        Alternatively
        {{ " " }}
        <a href="#" class="font-semibold text-indigo-600 hover:text-indigo-500"
          >Sign in using M-login</a
        >
      </p>
    </div>
    <div
      class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-100"
    >
      <div class="bg-white shadow sm:rounded-lg w-1/2 h-2/3">
        <div class="px-4 py-5 sm:p-6 h-full flex flex-col">
          <h3 class="text-base font-semibold text-gray-900">
            Tell us more about yourself!
          </h3>
          <p class="text-sm text-gray-500 mt-2">
            Please be sure to select at least one item in each category.
          </p>
          <div class="h-max flex-col justify-between flex">
            <div class="mt-6 text-sm text-gray-500 flex flex-row space-x-4 w-full">
              <div class="flex-1">
                <p>Selection content</p>
              </div>
              <div class="pr-12 py-12 sm:px-6 lg:px-8 flex-3" id="progressList">
                <nav class="flex justify-center" aria-label="Progress">
                  <ol role="list" class="space-y-6">
                    <li v-for="step in steps" :key="step.name">
                      <a
                        v-if="step.status === 'complete'"
                        :href="step.href"
                        class="group"
                      >
                        <span class="flex items-start">
                          <span
                            class="relative flex size-5 shrink-0 items-center justify-center"
                          >
                            <CheckCircleIcon
                              class="size-full text-indigo-600 group-hover:text-indigo-800"
                              aria-hidden="true"
                            />
                          </span>
                          <span
                            class="ml-3 text-sm font-medium text-gray-500 group-hover:text-gray-900"
                            >{{ step.name }}</span
                          >
                        </span>
                      </a>
                      <a
                        v-else-if="step.status === 'current'"
                        :href="step.href"
                        class="flex items-start"
                        aria-current="step"
                      >
                        <span
                          class="relative flex size-5 shrink-0 items-center justify-center"
                          aria-hidden="true"
                        >
                          <span class="absolute size-4 rounded-full bg-indigo-200" />
                          <span
                            class="relative block size-2 rounded-full bg-indigo-600"
                          />
                        </span>
                        <span class="ml-3 text-sm font-medium text-indigo-600">{{
                          step.name
                        }}</span>
                      </a>
                      <a v-else :href="step.href" class="group flex items-start">
                        <div class="flex items-start">
                          <div
                            class="relative flex size-5 shrink-0 items-center justify-center"
                            aria-hidden="true"
                          >
                            <div
                              class="size-2 rounded-full bg-gray-300 group-hover:bg-gray-400"
                            />
                          </div>
                          <p
                            class="ml-3 text-sm font-medium text-gray-500 group-hover:text-gray-900"
                          >
                            {{ step.name }}
                          </p>
                        </div>
                      </a>
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
            <div class="mt-5 flex justify-center space-x-4">
                <button
                type="button"
                class="inline-flex items-center rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500"
              >
                Previous
              </button>
              <button
                type="button"
                class="inline-flex items-center rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500"
              >
                Submit
              </button>
              <button
                type="button"
                class="inline-flex items-center rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500"
              >
                Next
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { CheckCircleIcon } from "@heroicons/vue/20/solid";

const steps = [
  { name: "Interests", href: "#", status: "complete" },
  { name: "Languages", href: "#", status: "current" },
  { name: "Event Types", href: "#", status: "upcoming" },
];
</script>

<style>
p {
  margin-top: 0px !important;
}
</style>
