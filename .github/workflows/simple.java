public void setup() {
    Caches.BRANCH_METADATA.invalidateAll();

    jenkins = mock(Jenkins.class);

    PowerMockito.mockStatic(Jenkins.class);
    when(Jenkins.getInstance()).thenReturn(jenkins);

    when(jenkins.getFullName()).thenReturn("");

    job = mock(Job.class);
    when(job.getParent()).thenReturn(jenkins);
    when(job.getFullName()).thenReturn("BobsPipeline");
    when(jenkins.getItemByFullName("BobsPipeline", Job.class)).thenReturn(job);

    org = mock(BlueOrganization.class);
    branch = new BranchImpl(org, job, new Link("foo"));
}
